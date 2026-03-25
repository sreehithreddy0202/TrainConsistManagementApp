import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Map bogies to their capacities
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);

        // Iterate and display
        System.out.println("Bogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " seats");
        }
    }
}




