import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18Test {

    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.linearSearch(ids, "BG309"), "Should find BG309 in the list");
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(Main.linearSearch(ids, "BG999"), "BG999 does not exist in the list");
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.linearSearch(ids, "BG101"), "Should find the first element BG101");
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(Main.linearSearch(ids, "BG550"), "Should find the last element BG550");
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(Main.linearSearch(ids, "BG101"), "Should work with a single-element array");
        assertFalse(Main.linearSearch(ids, "BG202"), "Should return false if single element doesn't match");
    }
}