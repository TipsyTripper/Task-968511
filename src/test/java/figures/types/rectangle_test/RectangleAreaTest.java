package figures.types.rectangle_test;

import figures.auxiliary.Point;
import figures.types.Parallelogram;
import figures.types.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RectangleAreaTest {
    private static Rectangle rectangle;

    private final Point a = new Point(3, 2, 3);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 3);
    private final Point d = new Point(7, 6, 5);


    @Test
    @DisplayName("If parallelogram invalid")
    public void areaOfFigure4Valid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
        coords.add(d);
        coords.add(c);
        rectangle = new Rectangle(coords);
        rectangle.checkOfValid();
        String answer = String.format("%.2f", rectangle.areaOfFigure());
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
        rectangle = new Rectangle(coords);
        rectangle.checkOfValid();
        String answer = String.format("%.2f", rectangle.areaOfFigure());
        Assertions.assertEquals("20,00", answer);
    }
}
