import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase19Test {

    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.binarySearch(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(Main.binarySearch(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElement() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElement() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.binarySearch(ids, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};
        assertFalse(Main.binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_MiddleElement() {
        String[] ids = {"A", "B", "C", "D", "E"};
        // "C" is exactly at mid = 2
        assertTrue(Main.binarySearch(ids, "C"));
    }
}