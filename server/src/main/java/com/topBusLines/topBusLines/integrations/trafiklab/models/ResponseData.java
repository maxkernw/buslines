package com.topBusLines.topBusLines.integrations.trafiklab.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Result")
    private List<T> result;

    @JsonProperty("Result")
    public List<T> getResult() {
        return result;
    }

    @JsonProperty("Result")
    public void setResult(List<T> result) {
        this.result = result;
    }
}
