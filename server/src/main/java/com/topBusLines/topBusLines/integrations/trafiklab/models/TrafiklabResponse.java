package com.topBusLines.topBusLines.integrations.trafiklab.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafiklabResponse<T> {

    @JsonProperty("StatusCode")
    private int statusCode;

    @JsonProperty("ExecutionTime")
    private int executionTime;

    @JsonProperty("ResponseData")
    private ResponseData<T> responseData;

    @JsonProperty("ResponseData")
    public ResponseData<T> getResponseData() {
        return responseData;
    }

    @JsonProperty("ResponseData")
    public void setResponseData(ResponseData<T> responseData) {
        this.responseData = responseData;
    }
}
