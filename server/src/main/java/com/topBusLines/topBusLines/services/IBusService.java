package com.topBusLines.topBusLines.services;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.models.BusLine;
import com.topBusLines.topBusLines.models.BusStop;

import java.util.List;

public interface IBusService {
    List<BusLine> getBusLines(int limit) throws TrafiklabRequestException;
}
