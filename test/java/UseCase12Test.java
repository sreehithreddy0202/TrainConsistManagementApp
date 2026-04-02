import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UseCase12Test {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> train = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(Main.checkSafetyCompliance(train), "Should be safe: Cylindrical has Petroleum");
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> train = Arrays.asList(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(Main.checkSafetyCompliance(train), "Should be unsafe: Cylindrical cannot carry Coal");
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> train = Arrays.asList(
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Box", "Iron Ore")
        );
        assertTrue(Main.checkSafetyCompliance(train), "Non-cylindrical bogies should pass with any cargo");
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> train = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Cylindrical", "Water") // Violation
        );
        assertFalse(Main.checkSafetyCompliance(train), "One violation should fail the entire train");
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> train = new ArrayList<>();
        assertTrue(Main.checkSafetyCompliance(train), "Empty train is technically safe (no violations)");
    }
}
