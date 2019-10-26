import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {
    List<Station> route;
    @Override
    protected void setUp() throws Exception {

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
}
