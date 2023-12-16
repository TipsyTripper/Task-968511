package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

public class Triangle extends Figure {

    private final ArrayList<Object> coords;

    private static boolean check = false;

    public Triangle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            for (int t = 0; t < coords.size() - 1; ++t) {
                double nowAper = VeryImportantMaths.strangerLength((Point)coords.get(t), (Point)coords.get(t + 1));
                if (nowAper == 0.0) {
                    System.out.println("The figure is invalid");
                    return false;
                }
            }
            System.out.println("The figure is valid");
            check = true;
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public double perimetr() {
        if (check) {
            double per = VeryImportantMaths.strangerLength((Point)coords.get(0), (Point)coords.get(1));
            per += VeryImportantMaths.strangerLength((Point)coords.get(1), (Point)coords.get(2));
            per += VeryImportantMaths.strangerLength((Point)coords.get(2), (Point)coords.get(0));
            System.out.printf("The figure area is %.2f\n", per);

            return per;
        }

        return super.perimetr();
    }
    public double areaOfFigure() {
        if (check) {
            double per = this.perimetr() / 2;
            double ar = per;
            ar *= per - VeryImportantMaths.strangerLength((Point)coords.get(0), (Point)coords.get(1));
            ar *= per - VeryImportantMaths.strangerLength((Point)coords.get(1), (Point)coords.get(2));
            ar *= per - VeryImportantMaths.strangerLength((Point)coords.get(2), (Point)coords.get(0));

            ar = Math.sqrt(ar);
            System.out.printf("The figure perimetr is %.2f\n", ar);

            return ar;
        }

        return  super.areaOfFigure();
    }
}
