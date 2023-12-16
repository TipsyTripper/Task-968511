package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;
import figures.consts.Consts;

import java.util.ArrayList;
import java.util.Stack;

public class Parallelogram extends Polygon {

    private final ArrayList<Object> coords;
    private static final Stack<Object> coordsIdStack = new Stack<>();
    private static final Stack<Object> coordsIdStack2 = new Stack<>();

    public Parallelogram(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 4) {
            super.checkOfValid();
            Stack<Object> coordsIdStack3 = (Stack<Object>) super.coordsIdStack.clone();

            Point theMain = (Point)coords.get(1);
            Point theSecond = (Point)coordsIdStack3.pop();
            Point theThird = (Point)coordsIdStack3.pop();
            Point theFourth = (Point)coordsIdStack3.pop();

            double length2 = VeryImportantMaths.strangerLength(theMain, theSecond);
            double length3 = VeryImportantMaths.strangerLength(theMain, theThird);
            double length4 = VeryImportantMaths.strangerLength(theMain, theFourth);

            double length23 = VeryImportantMaths.strangerLength(theSecond, theThird);
            double length43 = VeryImportantMaths.strangerLength(theFourth, theThird);
            double length24 = VeryImportantMaths.strangerLength(theFourth, theSecond);

            if (length23 != length4 || length2 != length43 || length3 < length2 || length3 < length23 || length3 < length43 || length3 < length4) {
                System.out.println("The figure is invalid");
                return false;
            } else {
                System.out.println("The figure is valid");
                return true;
            }
        }

        System.out.println("The figure is invalid");
        return false;
    }
}
