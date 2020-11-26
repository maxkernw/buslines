package com.topBusLines.topBusLines.services;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.integrations.trafiklab.ITrafiklabHttpService;
import com.topBusLines.topBusLines.mappers.IBusMapper;
import com.topBusLines.topBusLines.models.BusLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService implements IBusService {
    private final ITrafiklabHttpService trafiklabHttpService;
    private final IBusMapper busMapper;

    public BusService(ITrafiklabHttpService trafiklabHttpService, IBusMapper busMapper) {
        this.trafiklabHttpService = trafiklabHttpService;
        this.busMapper = busMapper;
    }

    @Override
    public List<BusLine> getBusLines(int limit) throws TrafiklabRequestException {
        var allJourneys = trafiklabHttpService.getAllJourneys();
        var allLines = trafiklabHttpService.getAllLines();
        var allStops = trafiklabHttpService.getAllStops();

        return busMapper.getBusLines(allJourneys, allLines, allStops, limit);
    }
}
