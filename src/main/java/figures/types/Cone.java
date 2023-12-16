package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class Cone extends Figure {
    private final ArrayList<Object> coords;

    private static boolean check = false;

    public Cone(ArrayList<Object> coords) {
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

            if (rectangular != null && rectangular == coords.get(0) && !centre.equals(round) && !centre.equals(cone) && !round.equals(cone)) {
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
            double rad1 = VeryImportantMaths.strangerLength((Point) coords.get(0), (Point) coords.get(1));
            double high = VeryImportantMaths.strangerLength((Point) coords.get(1), (Point) coords.get(2));

            double ar = 2 * PI * rad1 * (high + rad1);

            System.out.printf("The figure area is %.2f\n", ar);

            return ar;
        }
        return super.areaOfFigure();
    }
}
