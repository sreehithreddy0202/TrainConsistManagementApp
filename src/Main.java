public class Main {
    public static void main(String[] args) {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        boolean found = linearSearch(bogieIds, searchKey);

        System.out.println("Search for " + searchKey + ": " + (found ? "Found" : "Not Found"));
    }

    // UC18: Linear Search Implementation
    public static boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true; // Early termination: stop as soon as it's found
            }
        }
        return false; // Traversed the whole list and found nothing
    }
}