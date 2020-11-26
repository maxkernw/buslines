package com.topBusLines.topBusLines.integrations.trafiklab;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;

import java.util.List;

public interface ITrafiklabHttpService {
    List<Journey> getAllJourneys() throws TrafiklabRequestException;

    List<StopPoint> getAllStops() throws TrafiklabRequestException;

    List<Line> getAllLines() throws TrafiklabRequestException;
}
