import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        // Example usage
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID " + trainId + " is valid: " + validateTrainID(trainId));
        System.out.println("Cargo Code " + cargoCode + " is valid: " + validateCargoCode(cargoCode));
    }

    // UC11: Validate Train ID (Format: TRN- followed by exactly 4 digits)
    public static boolean validateTrainID(String trainId) {
        String regex = "^TRN-\\d{4}$";
        return Pattern.compile(regex).matcher(trainId).matches();
    }

    // UC11: Validate Cargo Code (Format: PET- followed by exactly 2 uppercase letters)
    public static boolean validateCargoCode(String cargoCode) {
        String regex = "^PET-[A-Z]{2}$";
        return Pattern.compile(regex).matcher(cargoCode).matches();
    }
}