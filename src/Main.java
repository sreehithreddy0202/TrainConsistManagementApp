import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] emptyTrain = {};

        try {
            // This should trigger the exception
            searchWithValidation(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }

    // UC20: Defensive Search with State Validation
    public static boolean searchWithValidation(String[] arr, String key) {
        // Step 1: Check if the collection is empty (The State Check)
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Search failed: No bogies available in the train consist.");
        }

        // Step 2: If not empty, perform the search (Reuse UC18 logic)
        for (String id : arr) {
            if (id.equals(key)) return true;
        }
        return false;
    }
}
