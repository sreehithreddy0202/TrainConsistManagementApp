import java.util.*;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }
}

public class Main {
    public static void main(String[] args) {
        List<GoodsBogie> goodsTrain = new ArrayList<>();
        goodsTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsTrain.add(new GoodsBogie("Open", "Coal"));

        boolean isSafe = checkSafetyCompliance(goodsTrain);
        System.out.println("Train Safety Compliance: " + (isSafe ? "PASS" : "FAIL"));
    }

    // UC12 Logic: Safety Rule Enforcement
    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> {
            // Rule: If it's Cylindrical, it MUST be Petroleum.
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargo().equalsIgnoreCase("Petroleum");
            }
            // Other types (Open, Box, etc.) are always considered safe for now.
            return true;
        });
    }
}