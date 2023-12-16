package figures.types;

import figures.auxiliary.VeryImportantMaths;
import figures.consts.Consts;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class Sphere extends Figure {

    private final ArrayList<Object> coords;
    private static double lengthOf;

    private static boolean check = false;

    public Sphere(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 2) {
            System.out.println("The figure is valid");
            lengthOf = VeryImportantMaths.strangerLength(coords);
            check = true;
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }
    @Override
    public double areaOfFigure() {
        if (check) {
            double ar = Consts.FOUR * PI * Math.pow(lengthOf, 2);
            System.out.printf("The figure area is %.2f\n", ar);
            return ar;
        }

        return super.areaOfFigure();
    }
}
