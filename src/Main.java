import java.util.*;

// UC15: Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = "Empty";
    }

    public String getShape() { return shape; }
    public String getCargo() { return cargo; }

    // UC15: Business logic for assignment with exception handling
    public void assignCargo(String newCargo) {
        try {
            System.out.println("Validating assignment: " + newCargo + " to " + shape + " bogie.");

            // Safety Rule: Petroleum cannot go into Rectangular bogies
            if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("UNSAFE: Petroleum cannot be assigned to a Rectangular bogie!");
            }

            this.cargo = newCargo;
            System.out.println("Assignment Successful: " + newCargo);

        } catch (CargoSafetyException e) {
            System.err.println("Caught Exception: " + e.getMessage());
        } finally {
            // This block always runs
            System.out.println("Cargo validation process completed for this bogie.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum"); // Should pass

        System.out.println("---");

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum"); // Should fail and be caught

        System.out.println("---");
        System.out.println("Program continues running safely...");
    }
}