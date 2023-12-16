package figures.auxiliary;

import java.util.ArrayList;

public class VeryImportantMathsTest {

    public static double strangerLength(ArrayList<Object> coords) {
        PointTest pointTest1 = (PointTest) coords.get(1);
        PointTest pointTest2 = (PointTest) coords.get(0);
        double x = Math.pow(pointTest1.getCoordinateX() - pointTest2.getCoordinateX(), 2);
        double y = Math.pow(pointTest1.getCoordinateY() - pointTest2.getCoordinateY(), 2);
        double z = Math.pow(pointTest1.getCoordinateZ() - pointTest2.getCoordinateZ(), 2);

        return Math.sqrt(x + y + z);
    }

    public static double strangerLength(PointTest pointTest1, PointTest pointTest2) {
        double x = Math.pow(pointTest1.getCoordinateX() - pointTest2.getCoordinateX(), 2);
        double y = Math.pow(pointTest1.getCoordinateY() - pointTest2.getCoordinateY(), 2);
        double z = Math.pow(pointTest1.getCoordinateZ() - pointTest2.getCoordinateZ(), 2);

        return Math.sqrt(x + y + z);
    }

    public static double vectorMulty(PointTest vector1, PointTest vector2) {
        double i = Math.pow(vector1.getCoordinateY() * vector2.getCoordinateZ() - vector1.getCoordinateZ() * vector2.getCoordinateY(), 2);
        double j = Math.pow(vector1.getCoordinateX() * vector2.getCoordinateZ() - vector1.getCoordinateZ() * vector2.getCoordinateX(), 2);
        double k = Math.pow(vector1.getCoordinateX() * vector2.getCoordinateY() - vector1.getCoordinateY() * vector2.getCoordinateX(), 2);;

        double result = Math.abs(Math.sqrt(i + j + k));
        return result;
    }

    public static PointTest vectorMaker(PointTest pointTest1, PointTest pointTest2) {
        PointTest vector = new PointTest(pointTest1.getCoordinateX() - pointTest2.getCoordinateX(), pointTest1.getCoordinateY() - pointTest2.getCoordinateY(), pointTest1.getCoordinateZ() - pointTest2.getCoordinateZ());

        return vector;
    }

    public static PointTest rectangular(PointTest pMain, PointTest pSec, PointTest pThird) {
        double mainSec = Math.pow(VeryImportantMathsTest.strangerLength(pMain, pSec), 2);
        double mainThird = Math.pow(VeryImportantMathsTest.strangerLength(pMain, pThird), 2);
        double secThird = Math.pow(VeryImportantMathsTest.strangerLength(pSec, pThird), 2);

        if (Math.sqrt(mainSec) == Math.sqrt(mainThird + secThird)) {
            return pThird;
        } else if (Math.sqrt(mainThird) == Math.sqrt(mainSec + secThird)) {
            return pSec;
        } else if (Math.sqrt(secThird) == Math.sqrt(mainSec + mainThird)) {
            return pMain;
        }
        return null;
    }

}
