package com.topBusLines.topBusLines.models;

public final class BusStop {

    public String name;
    public Double latitude;
    public Double longitude;

    public BusStop(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    public String getName() {
        return name;
    }
}
