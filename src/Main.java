import java.util.*;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    // Constructor that throws the custom exception
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
    public String getType() { return type; }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Valid Case
            PassengerBogie s1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + s1.getType() + " with " + s1.getCapacity() + " seats.");

            // Invalid Case (This will trigger the catch block)
            PassengerBogie s2 = new PassengerBogie("AC Chair", -5);

        } catch (InvalidCapacityException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}