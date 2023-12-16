package figures.types.polygon_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PolygonPerimetrTest {

    private static ArrayList<Object> coords;
    private static Polygon polygon;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(7, 6, 5);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
    }

    public void init2() {
        polygon = new Polygon(coords);
        polygon.checkOfValid();
    }

    @Test
    @DisplayName("If figure valid")
    public void perimetrTestIfFigureValid() {
        init2();
        String answer = String.format("%.2f", polygon.perimetr());
        Assertions.assertEquals("16,94", answer);
    }

    @Test
    @DisplayName("If figure invalid")
    public void perimetrTestIfFigureInvalid() {
        coords.add(b);
        init2();
        String answer = String.format("%.2f", polygon.perimetr());
        Assertions.assertEquals("0,00", answer);
    }
}
