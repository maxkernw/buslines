package com.topBusLines.topBusLines.models;

import java.util.List;

public final class BusLine {
    private final int lineNumber;
    private final List<BusStop> stops;

    public BusLine(int lineNumber, List<BusStop> stops) {
        this.lineNumber = lineNumber;
        this.stops = stops;
    }

    public List<BusStop> getStops() {
        return stops;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
