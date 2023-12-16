package figures.types.figure_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import figures.types.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FigureCheckOfValidTest {
    private static ArrayList<Object> coords;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
    }

    @Test
    @DisplayName("The only variant and answer")
    public void checkOfValidOk() {
        Figure figure = new Circle(coords);
        Assertions.assertTrue(figure.checkOfValid());
    }
}
