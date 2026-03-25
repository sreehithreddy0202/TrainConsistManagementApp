import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs (including intentional duplicates)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101");  // Duplicate - will be ignored
        bogieIDs.add("BG103");

        System.out.println("Unique bogie IDs: " + bogieIDs);
        System.out.println("Total unique IDs: " + bogieIDs.size());
    }
}


