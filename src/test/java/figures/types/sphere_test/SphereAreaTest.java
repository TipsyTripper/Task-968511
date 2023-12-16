package figures.types.sphere_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Sphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SphereAreaTest {
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

    public void init2() {
        sphere = new Sphere(coords);
        sphere.checkOfValid();
    }

    @Test
    @DisplayName("If circle invalid")
    public void areaOfFigure4Invalid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", sphere.areaOfFigure());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If circle valid")
    public void areaOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", sphere.areaOfFigure());
        Assertions.assertEquals("213,63", answer);
    }
}
