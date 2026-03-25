import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> passengerBogies = new ArrayList<>();

        // Add passenger bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After adding bogies: " + passengerBogies);

        // Remove a bogie
        passengerBogies.remove("AC Chair");

        // Check existence
        System.out.println("Sleeper exists: " + passengerBogies.contains("Sleeper"));

        System.out.println("Final bogies: " + passengerBogies);
        System.out.println("Bogie count: " + passengerBogies.size());
    }
}

