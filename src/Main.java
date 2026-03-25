import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }

    public int getCapacity() {
        return capacity;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> passengerBogies = new ArrayList<>();

        // Add passenger bogies
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        // Sort by capacity (descending)
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("Bogies sorted by capacity:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }
    }
}




