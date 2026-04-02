import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting: " + Arrays.toString(bogieNames));

        // UC17: Using Java's built-in optimized sorting
        sortBogieNames(bogieNames);

        System.out.println("After Arrays.sort(): " + Arrays.toString(bogieNames));
    }

    // Logic for UC17
    public static void sortBogieNames(String[] names) {
        Arrays.sort(names);
    }
}