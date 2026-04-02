import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14Test {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new PassengerBogie("Sleeper", 72);
        }, "Valid capacity should not throw an exception");
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        InvalidCapacityException thrown = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", -1);
        });
        assertTrue(thrown.getMessage().contains("greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.getType());
        assertEquals(24, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new PassengerBogie("Sleeper", 72);
            new PassengerBogie("AC Chair", 56);
            new PassengerBogie("General", 90);
        });
    }
}