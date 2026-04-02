import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class Main {
    // REFINEMENT: Extract logic to a method so JUnit can call it
    public static List<Bogie> filterHighCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        // Call the method
        List<Bogie> highCapacity = filterHighCapacity(passengerBogies, 60);

        System.out.println("High capacity bogies (>60 seats):");
        highCapacity.forEach(System.out::println);
    }
}
