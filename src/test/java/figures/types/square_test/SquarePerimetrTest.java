package figures.types.square_test;

import figures.auxiliary.Point;
import figures.types.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SquarePerimetrTest {
    private static ArrayList<Object> coords;
    private static Square square;

    private final Point a = new Point(3, 2, 5);
    private final Point b = new Point(3, 6, 5);
    private final Point c = new Point(7, 2, 5);
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
        square = new Square(coords);
        square.checkOfValid();
    }

    @Test
    @DisplayName("If square invalid")
    public void areaOfFigure4Valid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", square.perimetr());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If square valid")
    public void areaOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", square.perimetr());
        Assertions.assertEquals("23,33", answer);
    }
}
