package com.topBusLines.topBusLines.mappers;

import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;
import com.topBusLines.topBusLines.models.BusLine;
import com.topBusLines.topBusLines.models.BusStop;

import java.util.List;

public interface IBusMapper {
    List<BusLine> getBusLines(List<Journey> journeys, List<Line> lines, List<StopPoint> allStops, int limit);
    List<BusStop> getStops(List<Journey> journeys, List<StopPoint> stopPoints, int line);
}
