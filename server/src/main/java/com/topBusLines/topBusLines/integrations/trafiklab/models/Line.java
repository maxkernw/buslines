package com.topBusLines.topBusLines.integrations.trafiklab.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Line {

    @JsonProperty("LineNumber")
    private int lineNumber;

    @JsonProperty("LineDesignation")
    private String lineDesignation;

    @JsonProperty("DefaultTransportMode")
    private String defaultTransportMode;

    @JsonProperty("DefaultTransportModeCode")
    private String defaultTransportModeCode;

    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;

    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    @JsonProperty("LineNumber")
    public int getLineNumber() {
        return lineNumber;
    }

    @JsonProperty("LineNumber")
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

}
