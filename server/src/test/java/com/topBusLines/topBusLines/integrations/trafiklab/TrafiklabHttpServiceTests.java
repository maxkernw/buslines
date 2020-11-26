package com.topBusLines.topBusLines.integrations.trafiklab;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.http.proxies.HttpProxy;
import com.topBusLines.topBusLines.integrations.trafiklab.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrafiklabHttpServiceTests {

    @Mock
    private HttpProxy httpProxy;

    private TrafiklabHttpService sut;

    private final String expectedStopsUrl = "http://stops";
    private final String expectedJourneysUrl = "http://journeys";
    private final String expectedLinesUrl = "http://lines";

    @Before
    public void setup() {
        httpProxy = mock(HttpProxy.class);
        sut = new TrafiklabHttpService(httpProxy);

        ReflectionTestUtils.setField(sut, "stopsQuery", expectedStopsUrl);
        ReflectionTestUtils.setField(sut, "journeyQuery", expectedJourneysUrl);
        ReflectionTestUtils.setField(sut, "lineQuery", expectedLinesUrl);

    }

    @Test
    public void getAllStops_HttpProxy_Get_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new StopPoint()));

        sut.getAllStops();
        verify(httpProxy, times(1)).get(anyString(), any());
    }

    @Test
    public void getAllStops_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Type() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new StopPoint()));

        sut.getAllStops();

        verify(httpProxy).get(any(), ArgumentMatchers.<ParameterizedTypeReference<TrafiklabResponse<StopPoint>>>any());

    }

    @Test
    public void getAllStops_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Url() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new StopPoint()));

        sut.getAllStops();
        verify(httpProxy).get(argThat((String url) -> url == expectedStopsUrl), any());
    }

    @Test
    public void getAllLines_HttpProxy_Get_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Line()));

        sut.getAllLines();
        verify(httpProxy, times(1)).get(anyString(), any());
    }

    @Test
    public void getAllLines_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Type() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Line()));

        sut.getAllLines();

        verify(httpProxy).get(any(), ArgumentMatchers.<ParameterizedTypeReference<TrafiklabResponse<Line>>>any());

    }

    @Test
    public void getAllLines_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Url() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Line()));

        sut.getAllLines();

        verify(httpProxy).get(argThat((String url) -> url == expectedLinesUrl), any());
    }

    @Test
    public void getAllJourneys_HttpProxy_Get_Should_Have_Been_Called() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Journey()));

        sut.getAllJourneys();
        verify(httpProxy, times(1)).get(anyString(), any());
    }

    @Test
    public void getAllJourneys_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Type() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Line()));

        sut.getAllLines();

        verify(httpProxy).get(any(), ArgumentMatchers.<ParameterizedTypeReference<TrafiklabResponse<Journey>>>any());

    }

    @Test
    public void getAllJourneys_HttpProxy_Get_Should_Have_Been_Called_With_Expected_Url() throws TrafiklabRequestException {

        when(httpProxy.get(anyString(), any())).thenReturn(createResponseData(new Line()));

        sut.getAllJourneys();
        verify(httpProxy).get(argThat((String url) -> url == expectedJourneysUrl), any());
    }

    public <T> TrafiklabResponse<T> createResponseData(T t) {
        var response = new TrafiklabResponse<T>();
        var responseData = new ResponseData<T>();
        responseData.setResult(Arrays.asList(t));
        response.setResponseData(responseData);

        return response;
    }
}
