package com.topBusLines.topBusLines.comparators;

import com.topBusLines.topBusLines.models.BusStop;

import java.util.Comparator;

public class GeoLocationComparator implements Comparator<BusStop> {
    @Override
    public int compare(BusStop stopA, BusStop stopB) {
        var diffA = stopA.latitude + stopA.longitude;
        var diffB = stopB.latitude + stopB.longitude;
        if (diffA > diffB) {
            return 1;
        }
        return 0;
    }
}
