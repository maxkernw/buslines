package com.topBusLines.topBusLines.http.proxies;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpProxy implements IHttpProxy {

    private final RestTemplate restTemplate;

    public HttpProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T get(String url, ParameterizedTypeReference<T> ref) {
        ResponseEntity<T> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                ref);
        return response.getBody();
    }
}
