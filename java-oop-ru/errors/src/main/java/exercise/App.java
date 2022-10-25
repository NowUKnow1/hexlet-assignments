package exercise;

import static java.lang.Math.*;

// BEGIN
public class App {
    public static int printSquare(Circle circle) throws NegativeRadiusException{
        int result = 0;
        try {
            result = (int) round(circle.getSquare());
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        }
        if (result > 0) {
            System.out.println(result + "\nВычисление окончено");
        } else {
            System.out.println("Вычисление окончено");
        }
        return result;
    }
}
// END
