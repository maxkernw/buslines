package com.topBusLines.topBusLines.mappers;

import com.topBusLines.topBusLines.comparators.GeoLocationComparator;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;
import com.topBusLines.topBusLines.models.BusLine;
import com.topBusLines.topBusLines.models.BusStop;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusMapper implements IBusMapper {

    public List<BusLine> getBusLines(List<Journey> allJourneys, List<Line> allLines, List<StopPoint> allStops, int limit) {
        var groupedByLineNumber = groupByLineNumber(allJourneys);
        var sortedBySize = sortByNumberOfStops(groupedByLineNumber);

        return sortedBySize
                .entrySet()
                .stream()
                .limit(limit)
                .map(Map.Entry::getKey)
                .map(lineNumber -> allLines.stream().filter(line -> line.getLineNumber() == lineNumber))
                .map(lineStream -> {
                    var line = lineStream.findFirst().orElse(null);

                    if(line == null) {
                        return null;
                    }

                    var lineNumber = line.getLineNumber();
                    var stops = getStops(allJourneys, allStops, lineNumber);
                    return new BusLine(lineNumber, stops);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<BusStop> getStops(List<Journey> allJourneys, List<StopPoint> allStopPoints, int line) {
        var groupedJourneys = groupByLineNumber(allJourneys);

        if (!groupedJourneys.containsKey(line)) {
            return new ArrayList<>() {
            };
        }

        var stops = groupedJourneys.get(line).stream()
                .map(Journey::getJourneyPatternPointNumber)
                .map(pointNumber -> allStopPoints
                        .stream()
                        .filter(stopPoint -> stopPoint.getStopPointNumber() == pointNumber)
                        .map(stopPoint -> new BusStop(stopPoint.getStopPointName(), stopPoint.getLocationNorthingCoordinate(), stopPoint.getLocationEastingCoordinate()))
                        .findFirst()
                        .orElse(null)
                ).collect(Collectors.toList());
        stops.sort(new GeoLocationComparator());
        return stops;
    }

    private Map<Integer, List<Journey>> groupByLineNumber(List<Journey> allJourneys) {
        return allJourneys.stream().collect(Collectors.groupingBy(Journey::getLineNumber));
    }

    private Map<Integer, List<Journey>> sortByNumberOfStops(Map<Integer, List<Journey>> allJourneys) {
        return allJourneys
                .entrySet()
                .stream()
                .sorted(
                        Comparator.<Map.Entry<Integer, List<Journey>>>comparingInt(entry -> entry.getValue().size())
                                .reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }
}
