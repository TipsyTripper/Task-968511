package figures.types.polygon_test;

import figures.auxiliary.Point;
import figures.types.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PolygonAreaTest {
    private static Polygon polygon;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(7, 6, 5);

    @Test
    @DisplayName("If polygon invalid")
    public void areaOfFigure4Valid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(c);
        polygon = new Polygon(coords);
        polygon.checkOfValid();
        String answer = String.format("%.2f", polygon.areaOfFigure());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If polygon valid")
    public void areaOfFigure9Valid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
        polygon = new Polygon(coords);
        polygon.checkOfValid();
        String answer = String.format("%.2f", polygon.areaOfFigure());
        Assertions.assertEquals("17,89", answer);
    }
}
