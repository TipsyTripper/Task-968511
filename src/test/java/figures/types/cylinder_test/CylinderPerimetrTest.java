package figures.types.cylinder_test;

import figures.auxiliary.Point;
import figures.types.Cylinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CylinderPerimetrTest {
    private static ArrayList<Object> coords;
    private static Cylinder cylinder;

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

    public void init2() {
        cylinder = new Cylinder(coords);
        cylinder.checkOfValid();
    }

    @Test
    @DisplayName("If cylinder invalid")
    public void perimetrOfFigure4Valid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", cylinder.perimetr());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If cylinder valid")
    public void perimetrOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", cylinder.perimetr());
        Assertions.assertEquals("0,00", answer);
    }
}
