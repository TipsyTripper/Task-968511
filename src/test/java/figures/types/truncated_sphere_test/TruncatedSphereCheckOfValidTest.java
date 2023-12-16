package figures.types.truncated_sphere_test;

import figures.auxiliary.Point;
import figures.types.TruncatedSphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TruncatedSphereCheckOfValidTest {

    private static ArrayList<Object> coords1;
    private static TruncatedSphere truncatedSphereArea;

    private final Point a = new Point(4, 2, 3);
    private final Point b = new Point(5, 6, 3);
    private final Point c = new Point(4, 6, 4);

    @BeforeEach
    public void init() {
        coords1 = new ArrayList<>();
        coords1.add(a);
        coords1.add(b);
        coords1.add(c);
    }

    @Test
    @DisplayName("If all coords ok")
    public void checkOfValidOk() {
        truncatedSphereArea = new TruncatedSphere(coords1);
        Assertions.assertTrue(truncatedSphereArea.checkOfValid());
    }

    @Test
    @DisplayName("If wrong count of coords")
    public void checkOfValidNotOk() {
        coords1.remove(b);
        truncatedSphereArea = new TruncatedSphere(coords1);
        Assertions.assertFalse(truncatedSphereArea.checkOfValid());

        coords1.add(b);
        coords1.add(c);
        truncatedSphereArea = new TruncatedSphere(coords1);
        Assertions.assertFalse(truncatedSphereArea.checkOfValid());
    }

    @Test
    @DisplayName("If the same coords")
    public void checkOfValidIfTheSameCoords() {
        coords1.add(a);
        truncatedSphereArea = new TruncatedSphere(coords1);
        Assertions.assertFalse(truncatedSphereArea.checkOfValid());
    }
}
