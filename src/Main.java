import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new LinkedList<>();

        // Add bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Insert Pantry Car at position 2 (index 2)
        trainConsist.add(2, "Pantry Car");

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("Final train consist: " + trainConsist);
    }
}


