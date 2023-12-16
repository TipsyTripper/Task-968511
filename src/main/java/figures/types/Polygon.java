package figures.types;

import figures.auxiliary.Point;
import figures.auxiliary.VeryImportantMaths;
import figures.consts.Consts;

import java.util.ArrayList;
import java.util.Stack;

public class Polygon extends Figure {

    private ArrayList<Object> coords;
    protected final Stack<Object> coordsIdStack = new Stack<>();
    protected Stack<Object> coordsIdStack2 = new Stack<>();
    private static int indexOfLefterX = 0;
    private static Point mainPoint;

    private static boolean check = false;


    public Polygon(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() > 2) {
            coords = coordsReplace();

            if (!whichIsLefterAndHigher()) {
                System.out.println("The figure is invalid");
                return false;
            }

            for (int t = 0; t < coords.size(); ++t) {
                Point a = (Point)coords.get(t);
                for (int m = 0; m < coords.size(); ++m) {
                    if(m != t) {
                        Point b = (Point)coords.get(m);
                        int equals = (int)VeryImportantMaths.strangerLength(a, b);
                        if (equals == 0) {
                            System.out.println("The figure is invalid");
                            return false;
                        }
                    }
                }
            }

            mainPoint = (Point)coords.get(indexOfLefterX);
            Point theSeconds = (Point)coords.get(0);
            Point theThird = (Point)coords.get(1);

            Point mainVector = new Point(theSeconds.getCoordinateX() - mainPoint.getCoordinateX(), theSeconds.getCoordinateY() - mainPoint.getCoordinateY(), theSeconds.getCoordinateZ() - mainPoint.getCoordinateZ());
            Point secondMainVector = new Point(theThird.getCoordinateX() - mainPoint.getCoordinateX(), theThird.getCoordinateY() - mainPoint.getCoordinateY(), theThird.getCoordinateZ() - mainPoint.getCoordinateZ());

            for (int t = 2; t < coords.size(); ++t) {
                if (t != indexOfLefterX) {
                    Point otherPoint = (Point) coords.get(t);
                    Point otherVector = VeryImportantMaths.vectorMaker(otherPoint, mainPoint);

                    int plusD123 = mainVector.getCoordinateX() * secondMainVector.getCoordinateY() * otherVector.getCoordinateZ();
                    int plusStar1 = mainVector.getCoordinateY() * secondMainVector.getCoordinateZ() * otherVector.getCoordinateX();
                    int plusStar2 = mainVector.getCoordinateZ() * secondMainVector.getCoordinateX() * otherVector.getCoordinateY();
                    int plus = plusD123 + plusStar1 + plusStar2;
                    int minusD123 = mainVector.getCoordinateZ() * secondMainVector.getCoordinateY() * otherVector.getCoordinateX();
                    int minusStar1 = mainVector.getCoordinateY() * secondMainVector.getCoordinateX() * otherVector.getCoordinateZ();
                    int minusStar2 = mainVector.getCoordinateX() * secondMainVector.getCoordinateZ() * otherVector.getCoordinateY();
                    int minus = - minusD123 - minusStar1 - minusStar2;

                    if (plus + minus != 0) {
                        System.out.println("The figure is invalid");
                        return false;
                    }
                }
            }

            System.out.println("The figure is valid");
            check = true;
            return true;
        }

        System.out.println("The figure is invalid");
        return false;
    }

    public boolean whichIsLefterAndHigher() {
        int higherY;
        int lefterX = Consts.DEVIL_MAX;
        for (int t = 0; t < coords.size(); ++t) {
            Point point = (Point) coords.get(t);
            if (point.getCoordinateX() < lefterX) {
                lefterX = point.getCoordinateX();
                indexOfLefterX = t;
            }
        }

        ArrayList<Object> coordsForHigher = new ArrayList<>(coords);
        coordsForHigher.remove(indexOfLefterX);

        int indexOfHigherY = 0;
        int size = coords.size() - 1;
        for (int n = 0; n < size; ++n) {
            int xOfHigherY = Consts.DEVIL_MAX;
            higherY = -Consts.DEVIL_MAX;
            for (int t = 0; t < coordsForHigher.size(); ++t) {
                Point higherPointHere = (Point)coordsForHigher.get(t);
                int yHere = higherPointHere.getCoordinateY();
                int xHere = higherPointHere.getCoordinateX();
                if (yHere > higherY) {
                    higherY = yHere;
                    indexOfHigherY = t;
                    xOfHigherY = xHere;
                }
            }

            for (int m = 0; m < coordsForHigher.size(); ++m) {
                Point lefterAndHigherPointHere = (Point) coordsForHigher.get(m);
                int yHere = lefterAndHigherPointHere.getCoordinateY();
                int xHere = lefterAndHigherPointHere.getCoordinateX();
                Point mainPoint = (Point) coords.get(indexOfLefterX);
                if (yHere == higherY && xHere < xOfHigherY && yHere > mainPoint.getCoordinateY()) {
                    higherY = yHere;
                    indexOfHigherY = m;
                    xOfHigherY = xHere;
                } else if (yHere == higherY && xHere > xOfHigherY && yHere <= mainPoint.getCoordinateY()) {
                    higherY = yHere;
                    indexOfHigherY = m;
                    xOfHigherY = xHere;
                }
            }

            coordsIdStack.push(coordsForHigher.get(indexOfHigherY));
            coordsIdStack2.push(coordsForHigher.get(indexOfHigherY));
            coordsForHigher.remove(indexOfHigherY);
        }
        return true;
    }

    @Override
    public double perimetr() {
        if (check) {
            Point special1 = (Point) coordsIdStack.peek();
            double per = VeryImportantMaths.strangerLength(special1, mainPoint);

            Point special2 = new Point(0, 0, 0);

            for (int t = 0; t < coordsIdStack.size(); ++t) {
                special1 = (Point)coordsIdStack.pop();
                special2 = (Point)coordsIdStack.peek();

                per += VeryImportantMaths.strangerLength(special1, special2);
            }
            per += VeryImportantMaths.strangerLength(mainPoint, special2);

            System.out.printf("The figure perimetr is %.2f\n", per);
            return per;
        }

        return super.perimetr();
    }

    @Override
    public double areaOfFigure() {
        if (check) {
            Point main = (Point) coords.get(indexOfLefterX);
            double ar = 0;
            while (coordsIdStack2.size() != 1) {
                ArrayList<Object> triangleCoords = new ArrayList<>();
                triangleCoords.add(main);
                triangleCoords.add(coordsIdStack2.pop());
                triangleCoords.add(coordsIdStack2.peek());
                Triangle triangle = new Triangle(triangleCoords);
                triangle.checkOfValid();

                ar += triangle.areaOfFigure();
            }

            System.out.printf("The figure area is %.2f\n", ar);
            return ar;
        }

        return super.areaOfFigure();
    }

    private ArrayList<Object> coordsReplace() {
        for (int t = 0; t < coords.size(); ++t) {
            Point pointA = (Point)coords.get(t);
            for (int m = 0; m < coords.size(); ++m) {
                if(m != t) {
                    Point pointB = (Point)coords.get(m);
                    boolean zet = pointA.getCoordinateY() == pointB.getCoordinateY();
                    boolean iks = pointA.getCoordinateX() == pointB.getCoordinateX();
                    if (zet && iks) {
                        ArrayList<Object> coords2 = new ArrayList<>();
                        for (int i = 0; i < coords.size(); ++i) {
                            pointA = (Point)coords.get(i);
                            Point special = new Point(pointA.getCoordinateZ(), pointA.getCoordinateY(), pointA.getCoordinateX());
                            coords2.add(special);
                        }
                        return coords2;
                    }
                }
            }
        }
        return coords;
    }

}
