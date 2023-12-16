package figures.types.triangle_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TriangleCheckOfValidTest {
    private static ArrayList<Object> coords;
    private static Triangle triangle;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 2, 7);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
    }

    @Test
    @DisplayName("If all coords ok")
    public void checkOfValidOk() {
        triangle = new Triangle(coords);
        Assertions.assertTrue(triangle.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.remove(b);
        triangle = new Triangle(coords);
        Assertions.assertFalse(triangle.checkOfValid());

        coords.add(b);
        coords.add(c);
        triangle = new Triangle(coords);
        Assertions.assertFalse(triangle.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.add(a);
        triangle = new Triangle(coords);
        Assertions.assertFalse(triangle.checkOfValid());
    }
}
