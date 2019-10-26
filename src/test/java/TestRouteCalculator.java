import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {
    List<Station> route;
    List<Station> route2;
    //RouteCalculator calculator = new RouteCalculator();

    @Override
    protected void setUp() throws Exception {
        //calculator.ge
        Line Line1 = new Line(1, "First");
        Line Line2 = new Line(2, "Second");

        route = new ArrayList<>();
        route.add(new Station("Собянинская", Line1));
        route.add(new Station("Госушная", Line1));
        route.add(new Station("Бюджетраспилочная", Line2));
        route.add(new Station("Психбольница", Line2));

    }

    public void  testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected,actual);
    }
    public void testGetShortestRoute()
    {
        StationIndex testIndex = new StationIndex();
        Line Line1 = new Line(1,"First");
        Line Line2 = new Line(2,"Second");
        testIndex.addLine(Line1);
        testIndex.addLine(Line2);
        Station new1 = new Station("New1", Line1);
        Station new2 = new Station("New2",Line1);
        Station new3 = new Station("New3", Line1);
        testIndex.addStation(new1);
        testIndex.addStation(new2);
        testIndex.addStation(new3);
        Line1.addStation(new1);
        Line1.addStation(new2);
        Line1.addStation(new3);


        RouteCalculator testCalculator = new RouteCalculator(testIndex);

        route2 = new ArrayList<>();
        route2.add(new1);
        route2.add(new2);
        route2.add(new3);

        List<Station> actual = testCalculator.getShortestRoute(new1,new3);
        List<Station> expected = route2;

        assertEquals(route2,actual);


    }
}
