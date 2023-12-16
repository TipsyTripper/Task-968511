package figures.types;

import java.util.ArrayList;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import static java.lang.Math.PI;

public class Circle extends Figure {

    private final ArrayList<Object> coords;
    private static double lengthOf;

    private static boolean check = false;

    public Circle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 2) {
            for (int t = 0; t < coords.size() - 1; ++t) {
                double nowAper = VeryImportantMaths.strangerLength((Point)coords.get(t), (Point)coords.get(t + 1));
                if (nowAper == 0.0) {
                    System.out.println("The figure is invalid");
                    return false;
                }
            }
            System.out.println("The figure is valid");
            lengthOf = VeryImportantMaths.strangerLength(coords);
            check = true;
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double perimetr() {
        if (check) {
            double per = lengthOf * PI * 2;
            System.out.printf("The figure perimetr is %.2f\n", per);

            return per;
        }
        return super.perimetr();
    }
    @Override
    public double areaOfFigure() {
        if (check) {
            double ar = PI * Math.pow(lengthOf, 2);
            System.out.printf("The figure area is %.2f\n", ar);

            return ar;
        }
        return super.areaOfFigure();
    }

}
