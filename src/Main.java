import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies (insertion order preserved)
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");  // Duplicate - ignored

        System.out.println("Train formation (insertion order): " + trainFormation);
        System.out.println("Unique bogies: " + trainFormation.size());
    }
}



