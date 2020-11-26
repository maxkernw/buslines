package com.topBusLines.topBusLines.services;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.integrations.trafiklab.TrafiklabHttpService;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;
import com.topBusLines.topBusLines.mappers.BusMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusServiceTests {

    @Mock
    private TrafiklabHttpService httpService;

    @Mock
    private BusMapper busMapper;

    private BusService sut;

    List<StopPoint> stopPoints = new ArrayList();
    List<Journey> allJourneys = new ArrayList();
    List<Line> lines = new ArrayList();

    @Before
    public void setup() {
        httpService = mock(TrafiklabHttpService.class);
        busMapper = mock(BusMapper.class);

        sut = new BusService(httpService, busMapper);
    }

    @Test
    public void linesOrderedByStops_TrafiklabHttpService_getAllJourneys_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpService.getAllStops()).thenReturn(stopPoints);
        when(httpService.getAllJourneys()).thenReturn(allJourneys);
        when(httpService.getAllLines()).thenReturn(lines);

        sut.getBusLines(10);

        verify(httpService, times(1)).getAllJourneys();
    }

    @Test
    public void linesOrderedByStops_TrafiklabHttpService_getAllStops_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpService.getAllStops()).thenReturn(stopPoints);
        when(httpService.getAllJourneys()).thenReturn(allJourneys);
        when(httpService.getAllLines()).thenReturn(lines);

        sut.getBusLines(10);

        verify(httpService, times(1)).getAllStops();
    }

    @Test
    public void linesOrderedByStops_TrafiklabHttpService_getAllLines_Should_Have_Been_Called() throws TrafiklabRequestException {
        when(httpService.getAllStops()).thenReturn(stopPoints);
        when(httpService.getAllJourneys()).thenReturn(allJourneys);
        when(httpService.getAllLines()).thenReturn(lines);


        sut.getBusLines(10);
        verify(httpService, times(1)).getAllLines();
    }

    @Test
    public void linesOrderedByStops_BusMapper_getBusLines_Should_Have_Been_Called_Once_With_Expected_Parameters() throws TrafiklabRequestException {
        when(httpService.getAllStops()).thenReturn(stopPoints);
        when(httpService.getAllJourneys()).thenReturn(allJourneys);
        when(httpService.getAllLines()).thenReturn(lines);

        int expectedParameter = 10;

        sut.getBusLines(expectedParameter);

        verify(busMapper, times(1)).getBusLines(allJourneys,lines, stopPoints, expectedParameter);
    }

    @Test
    public void getAllStopsForLine_TrafiklabHttpService_getAllJourneys_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpService.getAllStops()).thenReturn(stopPoints);
        when(httpService.getAllJourneys()).thenReturn(allJourneys);
        when(httpService.getAllLines()).thenReturn(lines);

        sut.getBusLines(10);

        verify(httpService, times(1)).getAllJourneys();
    }
}
