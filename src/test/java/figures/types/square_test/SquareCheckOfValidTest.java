package figures.types.square_test;

import figures.auxiliary.Point;
import figures.types.Square;
import figures.types.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SquareCheckOfValidTest {
    private static ArrayList<Object> coords;
    private static Square square;

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
        square = new Square(coords);
        Assertions.assertTrue(square.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords.remove(b);
        square = new Square(coords);
        Assertions.assertFalse(square.checkOfValid());

        coords.add(b);
        coords.add(c);
        square = new Square(coords);
        Assertions.assertFalse(square.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords.remove(b);
        coords.add(a);
        square = new Square(coords);
        Assertions.assertFalse(square.checkOfValid());
    }
}
