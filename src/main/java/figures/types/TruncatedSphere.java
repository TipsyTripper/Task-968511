package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class TruncatedSphere extends Figure {

    private final ArrayList<Object> coords;
    private static double lengthOf;

    private static boolean check = false;

    public TruncatedSphere(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            Point centre = (Point) coords.get(0);
            Point rad = (Point) coords.get(1);
            Point slice = (Point) coords.get(2);

            lengthOf = VeryImportantMaths.strangerLength(centre, rad);
            if (lengthOf == VeryImportantMaths.strangerLength(centre, slice)) {
                System.out.println("The figure is valid");
                check = true;
                return true;
            }
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public double areaOfFigure() {
        if (check) {
            Point centre = (Point)coords.get(0);
            Point slice = (Point)coords.get(2);
            Point underCentre = new Point(centre.getCoordinateX(), slice.getCoordinateY(), centre.getCoordinateZ());

            double high = lengthOf - VeryImportantMaths.strangerLength(underCentre, centre);
            double ar = 2 * PI * lengthOf * high;

            System.out.printf("The figure area is %.2f\n", ar);

            return ar;
        }

        return super.areaOfFigure();
    }
}
