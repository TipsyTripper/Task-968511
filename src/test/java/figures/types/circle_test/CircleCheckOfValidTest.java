package figures.types.circle_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CircleCheckOfValidTest {

    private static ArrayList<Object> coords1;
    private static Circle circle1;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 2, 7);

    @BeforeEach
    public void init() {
        coords1 = new ArrayList<>();
        coords1.add(a);
        coords1.add(b);
    }

    @Test
    @DisplayName("If all coords ok")
    public void checkOfValidOk() {
        circle1 = new Circle(coords1);
        then(circle1.checkOfValid()).isEqualTo(true);
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords1.remove(b);
        circle1 = new Circle(coords1);
        Assertions.assertFalse(circle1.checkOfValid());

        coords1.add(b);
        coords1.add(c);
        circle1 = new Circle(coords1);
        then(circle1.checkOfValid()).isEqualTo(false);
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords1.add(a);
        circle1 = new Circle(coords1);
        then(circle1.checkOfValid()).isEqualTo(false);
    }
}
