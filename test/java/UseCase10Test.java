import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UseCase10Test {

    @Test
    void testReduce_TotalSeatCalculation() {
        // Verifies the final sum is correct
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC", 50));
        int total = Main.calculateTotalSeats(list);
        assertEquals(122, total, "Total should be exactly 122");
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // Verifies multiple bogies all contribute to the sum
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 50),
                new Bogie("First", 20)
        );
        int total = Main.calculateTotalSeats(list);
        assertEquals(142, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Verifies behavior with only one item
        List<Bogie> list = Collections.singletonList(new Bogie("Sleeper", 72));
        int total = Main.calculateTotalSeats(list);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Verifies empty list returns 0 (the identity value)
        List<Bogie> list = new ArrayList<>();
        int total = Main.calculateTotalSeats(list);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // Verifies map() gets the right numbers before summing
        List<Bogie> list = Arrays.asList(new Bogie("Test", 100));
        int total = Main.calculateTotalSeats(list);
        assertEquals(100, total, "Extraction failed to get the capacity");
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        // Verifies no bogie is skipped during reduction
        List<Bogie> list = Arrays.asList(new Bogie("A", 10), new Bogie("B", 10), new Bogie("C", 10));
        int total = Main.calculateTotalSeats(list);
        assertEquals(30, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Verifies stream processing doesn't break the original data
        List<Bogie> list = new ArrayList<>(Arrays.asList(new Bogie("Sleeper", 72)));
        int sizeBefore = list.size();
        Main.calculateTotalSeats(list);
        assertEquals(sizeBefore, list.size(), "The original list was modified!");
    }
}
