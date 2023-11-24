package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class Cone extends Figure {
    private static ArrayList<Object> coords;

    public Cone(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {

            Point rectangular = VeryImportantMaths.rectangular((Point)coords.get(0), (Point)coords.get(1), (Point)coords.get(2));
            if (rectangular != null && rectangular == (Point)coords.get(0)) {
                System.out.println("The figure is valid");
                return true;
            }
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public double areaOfFigure() {
        double rad1 = VeryImportantMaths.strangerLength((Point)coords.get(0), (Point)coords.get(1));

        double ar = 2 * PI * rad1 * (VeryImportantMaths.strangerLength((Point)coords.get(1), (Point)coords.get(2)) + rad1);

        System.out.printf("The figure area is %.2f\n", ar);

        return ar;
    }
}
