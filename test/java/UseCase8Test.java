import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UseCase8Test {

    int limit = 70; // Your threshold

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("High", 75));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Equal", 70));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(new Bogie("Low", 65));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("A", 80), new Bogie("B", 90), new Bogie("C", 50));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("Low1", 40), new Bogie("Low2", 50));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(new Bogie("High1", 100), new Bogie("High2", 110));
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        List<Bogie> result = Main.filterHighCapacity(list, limit);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>(Arrays.asList(new Bogie("Stay", 75)));
        int originalSize = list.size();
        Main.filterHighCapacity(list, limit);
        assertEquals(originalSize, list.size(), "Original list should not change!");
    }
}
