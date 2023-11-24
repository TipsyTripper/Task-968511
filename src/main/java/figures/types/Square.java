package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

public class Square extends Figure {

    private static ArrayList<Object> coords;
    private static double side;
    private static Polygon pole;

    public Square(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

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

            if (lengthMin > lengthMax) {
                side = lengthMax;
            } else {
                side = lengthMin;
            }
            pole = new Polygon(coords);
            return pole.checkOfValid();
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public double perimetr() {
        double per = side * Consts.FOUR;
        System.out.printf("The figure perimetr is %.2f\n", per);

        return per;
    }

    public double areaOfFigure() {
        double ar = Math.pow(side, 2);
        System.out.printf("The figure area is %.2f\n", ar);

        return ar;
    }
}