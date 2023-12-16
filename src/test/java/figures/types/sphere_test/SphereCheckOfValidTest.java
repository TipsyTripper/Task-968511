package figures.types.sphere_test;

import figures.auxiliary.Point;
import figures.types.Sphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SphereCheckOfValidTest {
    private static ArrayList<Object> coords;
    private static Sphere sphere;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 2, 7);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
    }

    @Test
    @DisplayName("If all coords ok")
    public void checkOfValidOk() {
        sphere = new Sphere(coords);
        Assertions.assertTrue(sphere.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.remove(b);
        sphere = new Sphere(coords);
        Assertions.assertFalse(sphere.checkOfValid());

        coords.add(b);
        coords.add(c);
        sphere = new Sphere(coords);
        Assertions.assertFalse(sphere.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.add(a);
        sphere = new Sphere(coords);
        Assertions.assertFalse(sphere.checkOfValid());
    }
}
