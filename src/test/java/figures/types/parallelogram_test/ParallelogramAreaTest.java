package figures.types.parallelogram_test;

import figures.auxiliary.Point;
import figures.types.Parallelogram;
import figures.types.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParallelogramAreaTest {
    private static ArrayList<Object> coords;
    private static Parallelogram parallelogram;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(1, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(5, 6, 5);


    @Test
    @DisplayName("If parallelogram invalid")
    public void areaOfFigure4Valid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
        coords.add(c);
        parallelogram = new Parallelogram(coords);
        parallelogram.checkOfValid();
        String answer = String.format("%.2f", parallelogram.areaOfFigure());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If parallelogram valid")
    public void areaOfFigure9Valid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
        parallelogram = new Parallelogram(coords);
        parallelogram.checkOfValid();
        String answer = String.format("%.2f", parallelogram.areaOfFigure());
        Assertions.assertEquals("17,89", answer);
    }
}
