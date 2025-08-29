public class Product {
    private final String code;      // e.g., "A1"
    private final String name;      // e.g., "Coke"
    private final double price;     // e.g., 1.50
    private int quantity;           // e.g., 5

    public Product(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Inventory manipulation
    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public boolean isAvailable() {
        return quantity > 0;
    }
}
