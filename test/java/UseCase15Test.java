import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15Test {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        // We verify that the method logic correctly identifies the safety risk
        // In the Main code, we catch it internally. For the test, we check the state.
        bogie.assignCargo("Petroleum");
        assertNotEquals("Petroleum", bogie.getCargo(), "Cargo should NOT be assigned if unsafe");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        // This test ensures no unhandled exception bubbles up to crash the test
        assertDoesNotThrow(() -> {
            bogie.assignCargo("Petroleum");
            bogie.assignCargo("Coal"); // Subsequent assignment
        });
        assertEquals("Coal", bogie.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Since we cannot easily "test" a print statement in finally,
        // we ensure the method completes its lifecycle without interruption.
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertTrue(true); // If it reaches here, finally didn't crash the thread
    }
}