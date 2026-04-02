import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11Test {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Main.validateTrainID("TRN-1234"), "Valid Train ID should be accepted");
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Main.validateTrainID("TRAIN12"), "Missing hyphen should be invalid");
        assertFalse(Main.validateTrainID("TRN12A"), "Letters in numeric part should be invalid");
        assertFalse(Main.validateTrainID("1234-TRN"), "Wrong order should be invalid");
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Main.validateCargoCode("PET-AB"), "Valid Cargo Code should be accepted");
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Main.validateCargoCode("PET123"), "Digits instead of letters should be invalid");
        assertFalse(Main.validateCargoCode("AB-PET"), "Wrong order should be invalid");
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Main.validateTrainID("TRN-123"), "3 digits should be rejected");
        assertFalse(Main.validateTrainID("TRN-12345"), "5 digits should be rejected");
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Main.validateCargoCode("PET-ab"), "Lowercase letters should be rejected");
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Main.validateTrainID(""), "Empty Train ID should be invalid");
        assertFalse(Main.validateCargoCode(""), "Empty Cargo Code should be invalid");
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Main.validateTrainID("TRN-1234EXTRA"), "Extra characters should make it invalid");
    }
}
