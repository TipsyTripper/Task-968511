package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class Cylinder extends Figure {

    private final ArrayList<Object> coords;

    private static boolean check = false;
    public Cylinder(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            Point centre = (Point)coords.get(0);
            Point round = (Point)coords.get(1);
            Point cone = (Point)coords.get(2);
            Point rectangular = VeryImportantMaths.rectangular(centre, round, cone);

            if (rectangular != null && rectangular != coords.get(2) && !centre.equals(round) && !centre.equals(cone) && !round.equals(cone)) {
                System.out.println("The figure is valid");
                check = true;
                return true;
            }
        }
        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double areaOfFigure() {
        if (check) {
            double ar;

            double rad1 = VeryImportantMaths.strangerLength((Point) coords.get(0), (Point) coords.get(2));
            double rad2 = VeryImportantMaths.strangerLength((Point) coords.get(1), (Point) coords.get(2));
            double high = VeryImportantMaths.strangerLength((Point) coords.get(0), (Point) coords.get(1));

            if (rad1 < rad2) {
                ar = 2 * PI * rad1 * high;
            } else {
                ar = 2 * PI * rad2 * high;
            }

            System.out.printf("The figure area is %.2f\n", ar);

            return ar;
        }
        return super.areaOfFigure();
    }
}
