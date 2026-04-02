import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20Test {

    @Test
    void testValidation_EmptyArrayThrowsException() {
        String[] emptyIds = {};
        // Verifies that IllegalStateException is thrown
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            Main.searchWithValidation(emptyIds, "BG101");
        });

        // Verifies the error message is meaningful
        assertEquals("Search failed: No bogies available in the train consist.", exception.getMessage());
    }

    @Test
    void testValidation_NullArrayThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            Main.searchWithValidation(null, "BG101");
        });
    }

    @Test
    void testValidation_ValidArrayDoesNotThrow() {
        String[] ids = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            Main.searchWithValidation(ids, "BG101");
        });
    }

    @Test
    void testValidation_SearchLogicStillWorks() {
        String[] ids = {"BG101", "BG205"};
        assertTrue(Main.searchWithValidation(ids, "BG205"));
        assertFalse(Main.searchWithValidation(ids, "BG999"));
    }
}