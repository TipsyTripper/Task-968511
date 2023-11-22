package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;

import java.util.ArrayList;

public class Triangle extends Figure {

    private static ArrayList<Object> coords;

    public Triangle(ArrayList<Object> coords) {
        super(coords);
    }

    private static boolean check;
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            System.out.println("The figure is valid");
            check = true;
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public void perimetr() {
        if (check) {
            Point vector1 = VeryImportantMaths.vectorMaker((Point)coords.get(1), (Point)coords.get(0));
            Point vector2 = VeryImportantMaths.vectorMaker((Point)coords.get(1), (Point)coords.get(2));

            double per = VeryImportantMaths.vectorMulty(vector1, vector2);
            System.out.printf("The figure perimetr is %.2f\n", per);
        }
    }
    public void areaOfFigure() {
        if (check) {
            double ar = 0;
            for (int t = 0; t < coords.size() - 1; ++t) {
                ar += VeryImportantMaths.strangerLength((Point)coords.get(t), (Point)coords.get(t + 1));
            }
            System.out.printf("The figure area is %.2f\n", ar);
        }
    }
}
