import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public int getCapacity() { return capacity; }
}

public class Main {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        // Loop Timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies, 60);
        long endLoop = System.nanoTime();
        System.out.println("Loop Time: " + (endLoop - startLoop) + " ns");

        // Stream Timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies, 60);
        long endStream = System.nanoTime();
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");
    }

    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }
}