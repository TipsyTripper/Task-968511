package figures.types.figure_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FigurePerimetrTest {
    private static ArrayList<Object> coords;
    private static Figure figure;

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
        figure = new Circle(coords);
        figure.checkOfValid();
    }

    @Test
    @DisplayName("The only variant and answer")
    public void areaOfFigure4Invalid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", figure.perimetr());
        Assertions.assertEquals("0,00", answer);
    }
}
