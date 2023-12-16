package figures.types.polygon_test;

import figures.auxiliary.Point;
import figures.types.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PolygonCheckOfValidTest {
    private static ArrayList<Object> coords;
    private static Polygon polygon;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(7, 6, 5);
    private final Point e = new Point(5, 4, 4);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
    }

    @Test
    @DisplayName("valid if all coords ok")
    public void checkOfValidOk() {
        polygon = new Polygon(coords);
        Assertions.assertTrue(polygon.checkOfValid());
    }

    @Test
    @DisplayName("not valid if the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.remove(b);
        coords.add(a);
        polygon = new Polygon(coords);
        Assertions.assertFalse(polygon.checkOfValid());
    }

    @Test
    @DisplayName("not valid if nonconvex")
    public void checkOfValidIfNonconvex() {
        coords.add(e);
        polygon = new Polygon(coords);
        Assertions.assertFalse(polygon.checkOfValid());
    }
}
