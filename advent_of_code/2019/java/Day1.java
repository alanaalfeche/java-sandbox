import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    private static int totalFuel = 0;
    
    private static void calculateFuel(double mass) {
        double fuel = Math.floor(mass / 3) - 2;
        double totalFuelPerMass = 0;

        if (fuel < 0) {
            return;
        } else {
            totalFuelPerMass += fuel;
            calculateFuel(fuel);
        }

        totalFuel += totalFuelPerMass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input/day-01"));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                int mass = Integer.parseInt(line);
                calculateFuel(mass);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        System.out.println("Total Fuel Requirement: " + totalFuel); // 3303995
    }
    
}
