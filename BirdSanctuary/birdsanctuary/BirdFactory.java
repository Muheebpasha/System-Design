package birdsanctuary;

public class BirdFactory {
    public static Bird getBird(String type) {
        return switch (type.toLowerCase()) {
            case "sparrow" -> new Sparrow();
            case "ostrich" -> new Ostrich();
            case "penguin" -> new Penguin();
            default -> throw new IllegalArgumentException("Unknown bird type: " + type);
        };
    }

    public static Flyer getFlyer(String type) {
        return switch (type.toLowerCase()) {
            case "sparrow" -> new Sparrow();
            // Add other flyers if needed
            default -> throw new IllegalArgumentException("This bird can't fly or not supported: " + type);
        };
    }
}
