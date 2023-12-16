package figures.types.cone_test;

import figures.auxiliary.Point;
import figures.types.Cone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConeCheckOfValidTest {

    private static ArrayList<Object> coords;
    private static Cone cone;

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
        cone = new Cone(coords);
        Assertions.assertTrue(cone.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.add(c);
        cone = new Cone(coords);
        Assertions.assertFalse(cone.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.remove(b);
        coords.add(a);
        cone = new Cone(coords);
        Assertions.assertFalse(cone.checkOfValid());
    }
}

