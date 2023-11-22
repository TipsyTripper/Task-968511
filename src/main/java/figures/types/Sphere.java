package figures.types;

import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class Sphere extends Figure {

    private static ArrayList<Object> coords;
    private static double lengthOf;

    public Sphere(ArrayList<Object> coords) {
        super(coords);
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 2) {
            System.out.println("The figure is valid");
            lengthOf = VeryImportantMaths.strangerLength(coords);
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }
    public void areaOfFigure() {
        double ar = Consts.FOUR * PI * Math.pow(lengthOf, 2);
        System.out.printf("The figure area is %.2f\n", ar);
    }
}
