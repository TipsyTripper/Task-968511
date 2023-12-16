package figures.types.parallelogram_test;

import figures.auxiliary.Point;
import figures.types.Parallelogram;
import figures.types.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParallelogramPerimetrTest {
    private static ArrayList<Object> coords;
    private static Parallelogram parallelogram;

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

    public void init2() {
        parallelogram = new Parallelogram(coords);
        parallelogram.checkOfValid();
    }

    @Test
    @DisplayName("If square invalid")
    public void areaOfFigure4Valid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", parallelogram.perimetr());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If square valid")
    public void areaOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", parallelogram.perimetr());
        Assertions.assertEquals("16,94", answer);
    }
}
