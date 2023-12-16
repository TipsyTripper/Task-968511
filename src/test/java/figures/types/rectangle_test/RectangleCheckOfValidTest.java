package figures.types.rectangle_test;

import figures.auxiliary.Point;
import figures.types.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RectangleCheckOfValidTest {
    private static Rectangle rectangle;

    private static ArrayList<Object> coords;
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

    @Test
    @DisplayName("If all coords ok")
    public void checkOfValidOk() {
        rectangle = new Rectangle(coords);
        Assertions.assertTrue(rectangle.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.remove(b);
        rectangle = new Rectangle(coords);
        Assertions.assertFalse(rectangle.checkOfValid());

        coords.add(b);
        coords.add(c);
        rectangle = new Rectangle(coords);
        Assertions.assertFalse(rectangle.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.remove(b);
        coords.add(a);
        rectangle = new Rectangle(coords);
        Assertions.assertFalse(rectangle.checkOfValid());
    }
}
