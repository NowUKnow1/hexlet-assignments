package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List buildAppartmentsList(List<Home> apartments, int number) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        return apartments.stream().sorted(Home::compareTo)
                .map(Object::toString).limit(number).collect(Collectors.toList());
    }
}
// END
