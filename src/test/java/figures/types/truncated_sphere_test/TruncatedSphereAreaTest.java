package figures.types.truncated_sphere_test;

import figures.auxiliary.Point;
import figures.types.TruncatedSphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TruncatedSphereAreaTest {

    private static ArrayList<Object> coords;
    private static TruncatedSphere truncatedSphere;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 6, 4);

    @BeforeEach
    public void init() {
        coords = new ArrayList<>();
        coords.add(a);
        coords.add(b);
        coords.add(c);
    }

    public void init2() {
        truncatedSphere = new TruncatedSphere(coords);
        truncatedSphere.checkOfValid();
    }

    @Test
    @DisplayName("If truncated sphere invalid")
    public void areaOfFigure4Invalid() {
        coords.add(c);
        init2();
        String answer = String.format("%.2f", truncatedSphere.areaOfFigure());
        Assertions.assertEquals("0,00", answer);
    }

    @Test
    @DisplayName("If truncated sphere valid")
    public void areaOfFigure9Valid() {
        init2();
        String answer = String.format("%.2f", truncatedSphere.areaOfFigure());
        Assertions.assertEquals("3,19", answer);
    }

}
