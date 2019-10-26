import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {
    List<Station> route;
    RouteCalculator testCalculator;
    Station test1l1;
    Station test2l1;
    Station test3l1;
    Station test1l2;
    Station test2l2;
    Station test3l2;
    Station test1l3;
    Station test2l3;
    Station test3l3;

    @Override
    protected void setUp() throws Exception {
        // create test lines
        Line Line1 = new Line(1, "First");
        Line Line2 = new Line(2, "Second");
        Line Line3 = new Line(3, "Third");

        //create test stations
        test1l1 = new Station("test1l1", Line1);
        test2l1 = new Station("test2l1", Line1);
        test3l1 = new Station("test3l1", Line1);
        test1l2 = new Station("test1l2",Line2);
        test2l2 = new Station("test2l2",Line2);
        test3l2 = new Station("test2l3", Line2);
        test1l3 = new Station("test1l3",Line3);
        test2l3 = new Station("test2l3", Line3);
        test3l3 = new Station("test3l3", Line3);

        //stations to lines
        Line1.addStation(test1l1);
        Line1.addStation(test2l1);
        Line1.addStation(test3l1);
        Line2.addStation(test1l2);
        Line2.addStation(test2l2);
        Line2.addStation(test3l2);
        Line3.addStation(test1l3);
        Line3.addStation(test2l3);
        Line3.addStation(test3l3);

        //create stationindex
        StationIndex testIndex = new StationIndex();

        //add everything to stationindex
        testIndex.addLine(Line1);
        testIndex.addLine(Line2);
        testIndex.addLine(Line3);
        testIndex.addStation(test1l1);
        testIndex.addStation(test2l1);
        testIndex.addStation(test3l1);
        testIndex.addStation(test1l2);
        testIndex.addStation(test2l2);
        testIndex.addStation(test3l2);
        testIndex.addStation(test1l3);
        testIndex.addStation(test2l3);
        testIndex.addStation(test3l3);

        testCalculator = new RouteCalculator(testIndex);
    }

    public void  testCalculateDuration()
    {
        route = new ArrayList<>();
        route.add(test1l1);
        route.add(test2l1);
        route.add(test3l1);

        double actual = testCalculator.calculateDuration(route);
        double expected = 5.0;
        assertEquals(expected,actual);
    }
//    public void testGetShortestRoute()
//    {
//        StationIndex testIndex = new StationIndex();
//        Line Line1 = new Line(1,"First");
//        Line Line2 = new Line(2,"Second");
//        testIndex.addLine(Line1);
//        testIndex.addLine(Line2);
//        Station new1 = new Station("New1", Line1);
//        Station new2 = new Station("New2",Line1);
//        Station new3 = new Station("New3", Line1);
//        testIndex.addStation(new1);
//        testIndex.addStation(new2);
//        testIndex.addStation(new3);
//        Line1.addStation(new1);
//        Line1.addStation(new2);
//        Line1.addStation(new3);
//
//
//     //   RouteCalculator testCalculator = new RouteCalculator(test);
//
//        //route2 = new ArrayList<>();
//        route.add(new1);
//        route.add(new2);
//        route.add(new3);
//
//        List<Station> actual = testCalculator.getShortestRoute(new1,new3);
//        List<Station> expected = route;
//
//        assertEquals(route,actual);
//
//
//    }
}
