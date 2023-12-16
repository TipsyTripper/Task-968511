package figures.types.cone_test;

import figures.auxiliary.Point;
import figures.types.Cone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConeAreaTest {

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

    public void init2() {
        cone = new Cone(coords);
        cone.checkOfValid();
    }

    @Test
    @DisplayName("If cone invalid")
    public void areaOfFigure4Valid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", cone.areaOfFigure());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If cone valid")
    public void areaOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", cone.areaOfFigure());
        Assertions.assertEquals("255,63", answer);
    }
}
