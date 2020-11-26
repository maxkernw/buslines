package com.topBusLines.topBusLines.integrations.trafiklab;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.http.proxies.IHttpProxy;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;
import com.topBusLines.topBusLines.integrations.trafiklab.models.TrafiklabResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafiklabHttpService implements ITrafiklabHttpService {

    @Value("${trafiklab.journey.query}")
    private String journeyQuery;

    @Value("${trafiklab.line.query}")
    private String lineQuery;

    @Value("${trafiklab.stops.query}")
    private String stopsQuery;

    private final IHttpProxy httpProxy;

    public TrafiklabHttpService(IHttpProxy httpProxy) {
        this.httpProxy = httpProxy;
    }

    @Cacheable("journeys")
    public List<Journey> getAllJourneys() throws TrafiklabRequestException {
        try {
            TrafiklabResponse<Journey> response = httpProxy.get(journeyQuery, new ParameterizedTypeReference<TrafiklabResponse<Journey>>() {});

            return response.getResponseData().getResult();

        } catch (Exception ex) {
            throw new TrafiklabRequestException("Unable to fetch data");
        }
    }

    @Cacheable("stops")
    public List<StopPoint> getAllStops() throws TrafiklabRequestException {
        try {
            TrafiklabResponse<StopPoint> response = httpProxy.get(stopsQuery, new ParameterizedTypeReference<TrafiklabResponse<StopPoint>>() {
            });

            return response.getResponseData().getResult();

        } catch (Exception ex) {
            throw new TrafiklabRequestException("Unable to fetch data");
        }
    }

    @Cacheable("lines")
    public List<Line> getAllLines() throws TrafiklabRequestException {
        try {
            TrafiklabResponse<Line> response = httpProxy.get(lineQuery, new ParameterizedTypeReference<TrafiklabResponse<Line>>() {
            });

            return response.getResponseData().getResult();

        } catch (Exception ex) {
            throw new TrafiklabRequestException("Unable to fetch data");
        }
    }
}
