package figures.types;

import java.util.ArrayList;

public class Figure {

    public Figure(ArrayList<Object> coords) {
    }

    public boolean checkOfValid() {
        System.out.println("The figure is figyre");
        return true;
    }
    public double areaOfFigure() {
        System.out.println("The figure has no area");
        return 0;
    }
    public double perimetr() {
        System.out.println("The figure has no perimetr");
        return 0;
    }
}
