package com.topBusLines.topBusLines.integrations.trafiklab.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopPoint {

    @JsonProperty("StopPointNumber")
    private int stopPointNumber;

    @JsonProperty("StopPointName")
    private String stopPointName;

    @JsonProperty("StopAreaNumber")
    private int stopAreaNumber;

    @JsonProperty("LocationNorthingCoordinate")
    private String locationNorthingCoordinate;

    @JsonProperty("LocationEastingCoordinate")
    private String locationEastingCoordinate;

    @JsonProperty("ZoneShortName")
    private String zoneShortName;

    @JsonProperty("StopAreaTypeCode")
    private String stopAreaTypeCode;

    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;

    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    @JsonProperty("StopPointNumber")
    public int getStopPointNumber() {
        return stopPointNumber;
    }

    @JsonProperty("StopPointNumber")
    public void setStopPointNumber(int stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    @JsonProperty("StopPointName")
    public String getStopPointName() {
        return stopPointName;
    }

    @JsonProperty("StopPointName")
    public void setStopPointName(String stopPointName) {
        this.stopPointName = stopPointName;
    }

    @JsonProperty("LocationNorthingCoordinate")
    public String getLocationNorthingCoordinate() {
        return locationNorthingCoordinate;
    }

    @JsonProperty("LocationNorthingCoordinate")
    public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
        this.locationNorthingCoordinate = locationNorthingCoordinate;
    }

    @JsonProperty("LocationEastingCoordinate")
    public String getLocationEastingCoordinate() {
        return locationEastingCoordinate;
    }

    @JsonProperty("LocationEastingCoordinate")
    public void setLocationEastingCoordinate(String locationEastingCoordinate) {
        this.locationEastingCoordinate = locationEastingCoordinate;
    }
}
