package figures.types;

import java.util.ArrayList;

public class Figure {

    private static ArrayList<Object> coords;

    public Figure(ArrayList<Object> coords) {
        this.coords = coords;
    }

    public boolean checkOfValid() {
        System.out.println("The figure is figyre");
        return true;
    }
    public void areaOfFigure() {
        System.out.println("The figure has no area");
        //System.out.printf("The figure area is %.2f\n", areaOfFigure);
    }
    public void perimetr() {
        System.out.println("The figure has no perimetr");
        //System.out.printf("The figure perimetr is %.2f\n", perimetr);
    }
}
