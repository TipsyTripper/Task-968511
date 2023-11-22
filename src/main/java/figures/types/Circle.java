package figures.types;

import java.util.ArrayList;
import figures.auxiliary.VeryImportantMaths;

import static java.lang.Math.PI;

public class Circle extends Figure {

    private static ArrayList<Object> coords;
    private static double lengthOf;

    public Circle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
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

    public void perimetr() {
        double per = lengthOf * PI * 2;
        System.out.printf("The figure perimetr is %.2f\n", per);
    }
    public void areaOfFigure() {
        double ar = PI * Math.pow(lengthOf, 2);
        System.out.printf("The figure area is %.2f\n", ar);
    }

}
