package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        String serializedCar = Car.serialize(car);
        try {
            Files.write(path, serializedCar.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        String result = null;
        BufferedReader reader = null;
        try {
            InputStream in = Files.newInputStream(path);
            reader = new BufferedReader(new InputStreamReader(in));
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Car.unserialize(result);
    }
}
// END
