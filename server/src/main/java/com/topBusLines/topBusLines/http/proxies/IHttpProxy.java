package com.topBusLines.topBusLines.http.proxies;

import org.springframework.core.ParameterizedTypeReference;

public interface IHttpProxy {
    <T> T get(String url, ParameterizedTypeReference<T> ref);
}
