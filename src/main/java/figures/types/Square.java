package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;
import figures.consts.Consts;

import java.util.ArrayList;

public class Square extends Polygon {

    private final ArrayList<Object> coords;
    private static double side;

    private static boolean check = false;

    public Square(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 4) {
            double lengthMin = 0;
            double lengthMax = 0;

            for (int t = 0; t < coords.size() - 1; ++t) {
                Point p1 = (Point) coords.get(t);
                Point p2 = (Point) coords.get(t + 1);

                double rad = VeryImportantMaths.strangerLength(p1, p2);
                if (lengthMin == 0) {
                    lengthMin = rad;
                } else if (lengthMax == 0) {
                    lengthMax = rad;
                }else if (rad != lengthMin && rad != lengthMax) {
                    System.out.println("The figure is invalid");
                    return false;
                }
            }

            side = Math.min(lengthMin, lengthMax);
            check = super.checkOfValid();
            return check;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double perimetr() {
        if (check) {
            double per = side * Consts.FOUR;
            System.out.printf("The figure perimetr is %.2f\n", per);

            return per;
        }
        return super.perimetr();
    }

    @Override
    public double areaOfFigure() {
        if (check) {
            double ar = Math.pow(side, 2);
            System.out.printf("The figure area is %.2f\n", ar);

            return ar;
        }

        return super.areaOfFigure();
    }
}