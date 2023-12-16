package figures.types.triangle_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TrianglePerimetrTest {
    private static ArrayList<Object> coords;
    private static Triangle triangle;

    private final Point a = new Point(3, 2, 4);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 4);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
    }

    public void init2() {
        triangle = new Triangle(coords);
        triangle.checkOfValid();
    }

    @Test
    @DisplayName("If figure valid")
    public void perimetrTestIfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", triangle.perimetr());
        Assertions.assertEquals("13,87", answer);
    }

    @Test
    @DisplayName("If figure invalid")
    public void perimetrTestIfFigure4Valid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", triangle.perimetr());
        Assertions.assertEquals("0,00", answer);
    }
}
