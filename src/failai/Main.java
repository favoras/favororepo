package failai;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        saveDrivers(Paths.get("src", "failai", "drivers_out"), Driver.drivers());

    }


    public static void saveDrivers(Path path, List<Driver> drivers)
    {
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            for (Driver driver : drivers)
            {
                writer.write(driver.toLine());
                writer.newLine();
            }
        }   catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}


class Driver {

    private String name;
    private String car;
    private String plate;
    private int milage;

    public Driver(String name, String car, String plate, int milage) {
        this.name = name;
        this.car = car;
        this.plate = plate;
        this.milage = milage;
    }

    public String toLine() {
        return String.format("%s, %s, %s, %d", this.name, this.car, this.plate, this.milage);
    }

    public static List<Driver> drivers() {
        return Arrays.asList(
                new Driver("John", "Mercedes Benz", "KLM 850", 120000),
                new Driver("Mark", "Audi", "ABC 123", 95000),
                new Driver("Lucas", "BMW", "KKK 888", 20000)
        );
    }
}