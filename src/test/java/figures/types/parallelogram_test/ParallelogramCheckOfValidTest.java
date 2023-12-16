package figures.types.parallelogram_test;

import figures.auxiliary.Point;
import figures.types.Parallelogram;
import figures.types.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParallelogramCheckOfValidTest {
    private static ArrayList<Object> coords;
    private static Parallelogram parallelogram;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(1, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(5, 6, 5);

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
        parallelogram = new Parallelogram(coords);
        Assertions.assertTrue(parallelogram.checkOfValid());
    }

    /*@Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.remove(b);
        parallelogram = new Parallelogram(coords);
        Assertions.assertFalse(parallelogram.checkOfValid());

        coords.add(b);
        coords.add(c);
        parallelogram = new Parallelogram(coords);
        Assertions.assertFalse(parallelogram.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.remove(b);
        coords.add(a);
        parallelogram = new Parallelogram(coords);
        Assertions.assertFalse(parallelogram.checkOfValid());
    }*/
}
