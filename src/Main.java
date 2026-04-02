import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Data MUST be sorted for Binary Search
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG412";

        boolean found = binarySearch(bogieIds, searchKey);

        System.out.println("Binary Search for " + searchKey + ": " + (found ? "Found" : "Not Found"));
    }

    // UC19: Binary Search Implementation
    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // Key found!
            } else if (comparison > 0) {
                low = mid + 1; // Key is in the right half
            } else {
                high = mid - 1; // Key is in the left half
            }
        }
        return false; // Key not found
    }
}
