package com.topBusLines.topBusLines.integrations.trafiklab.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Journey {

    @JsonProperty("LineNumber")
    private int lineNumber;

    @JsonProperty("DirectionCode")
    private int directionCode;

    @JsonProperty("JourneyPatternPointNumber")
    private int journeyPatternPointNumber;

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

    @JsonProperty("JourneyPatternPointNumber")
    public int getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    @JsonProperty("JourneyPatternPointNumber")
    public void setJourneyPatternPointNumber(int journeyPatternPointNumber) {
        this.journeyPatternPointNumber = journeyPatternPointNumber;
    }
}
