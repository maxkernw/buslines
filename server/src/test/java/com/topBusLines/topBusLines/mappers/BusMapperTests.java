package com.topBusLines.topBusLines.mappers;

import com.topBusLines.topBusLines.integrations.trafiklab.models.Journey;
import com.topBusLines.topBusLines.integrations.trafiklab.models.Line;
import com.topBusLines.topBusLines.integrations.trafiklab.models.StopPoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class BusMapperTests {

    BusMapper sut;

    @Before
    public void setup() {
        sut = new BusMapper();
    }

    @Test
    public void getStops_Should_Return_Expected_StopPoint() {
        var expectedJourney = createJourney(4, 456);
        var expectedStopPoint = createStopPoint(expectedJourney.getJourneyPatternPointNumber(), "expected", "lat", "long");

        var journeyList = Arrays.asList(
                createJourney(1,200),
                createJourney(1,300),
                expectedJourney
        );
        var stopPoints = Arrays.asList(
                createStopPoint(1, "","",""),
                createStopPoint(2, "","",""),
                expectedStopPoint
        );


        var actual = sut.getStops(journeyList, stopPoints, 4);

        Assert.assertEquals(1, actual.size());
        Assert.assertSame(actual.get(0).name, expectedStopPoint.getStopPointName());
    }

    @Test
    public void getStops_Should_Return_Empty_Array() {

        var journeyList = Arrays.asList(
                createJourney(1,200),
                createJourney(1,300)
        );

        var stopPoints = Arrays.asList(
                createStopPoint(1, "","",""),
                createStopPoint(2, "","","")
        );

        var actual = sut.getStops(journeyList, stopPoints, 4);

        Assert.assertEquals(0, actual.size());
    }

    @Test
    public void getBusLines_Should_Return_Empty_Array() {

        var journeyList = Arrays.asList(
                createJourney(1,200),
                createJourney(1,300)
        );

        var stopPoints = Arrays.asList(
                createStopPoint(1, "","",""),
                createStopPoint(2, "","","")
        );

        var lines = Arrays.asList(
                createLine(3)
        );

        var actual = sut.getBusLines(journeyList,lines, stopPoints, 100);

        Assert.assertEquals(0, actual.size());
    }

    @Test
    public void getBusLines_Should_Return_Expected_Amount_Of_BusLines_Given_Limit() {

        var journeyList = Arrays.asList(
                createJourney(1,1),
                createJourney(2,2),
                createJourney(3,3)
        );

        var stopPoints = Arrays.asList(
                createStopPoint(1, "","",""),
                createStopPoint(2, "","",""),
                createStopPoint(3, "","","")
        );

        var lines = Arrays.asList(
                createLine(1),
                createLine(2),
                createLine(3)

        );
        var expected = 2;

        var actual = sut.getBusLines(journeyList, lines, stopPoints, expected);

        Assert.assertEquals(expected, actual.size());
    }

    @Test
    public void getBusLines_Should_Return_Expected_BusStop() {
        var expected = createStopPoint(2, "expected","lat","long");

        var journeyList = Arrays.asList(
                createJourney(1,200),
                createJourney(200,2)
        );

        var stopPoints = Arrays.asList(
                createStopPoint(1, "","",""),
                expected
        );

        var lines = Arrays.asList(
                createLine(200)
        );

        var actual = sut.getBusLines(journeyList, lines, stopPoints, 100);

        Assert.assertEquals(actual.get(0).getStops().get(0).name, expected.getStopPointName());
        Assert.assertEquals(actual.get(0).getStops().get(0).latitude, expected.getLocationNorthingCoordinate());
        Assert.assertEquals(actual.get(0).getStops().get(0).longitude, expected.getLocationEastingCoordinate());

    }


    private Journey createJourney(int lineNumber, int patternPoint) {
        var journey = new Journey();
        journey.setLineNumber(lineNumber);
        journey.setJourneyPatternPointNumber(patternPoint);
        return journey;
    }

    private StopPoint createStopPoint(int number, String name, String latitude, String longitude) {
        var stopPoint = new StopPoint();

        stopPoint.setStopPointNumber(number);
        stopPoint.setStopPointName(name);
        stopPoint.setLocationNorthingCoordinate(latitude);
        stopPoint.setLocationEastingCoordinate(longitude);
        return stopPoint;
    }

    private Line createLine(int lineNumber) {
        var line = new Line();
        line.setLineNumber(lineNumber);
        return line;

    }
}
