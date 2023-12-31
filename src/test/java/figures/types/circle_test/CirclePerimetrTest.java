package figures.types.circle_test;

import figures.auxiliary.Point;
import figures.types.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CirclePerimetrTest {
    private static Circle circle;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 2, 7);

    @Test
    @DisplayName("If figure valid")
    public void perimetrTestIfFigureValid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        circle = new Circle(coords);
        circle.checkOfValid();
        String answer = String.format("%.2f", circle.perimetr());
        then(answer).isEqualTo("25,91");
    }

    @Test
    @DisplayName("If figure invalid")
    public void perimetrTestIfFigureInvalid() {
        ArrayList<Object> coords = new ArrayList<>();
        coords.add(a);
        circle = new Circle(coords);
        circle.checkOfValid();
        String answer = String.format("%.2f", circle.perimetr());
        then(answer).isEqualTo("0,00");
    }

}
