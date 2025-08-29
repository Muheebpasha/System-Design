import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getCode(), product);
    }

    public boolean hasItem(String code) {
        return products.containsKey(code) && products.get(code).isAvailable();
    }

    public void dispenseItem(String code) {
        if (!hasItem(code)) {
            throw new IllegalStateException("Product " + code + " is unavailable.");
        }
        products.get(code).reduceQuantity();
    }

    public boolean isAllSoldOut() {
        return products.values().stream().noneMatch(Product::isAvailable);
    }

    public Product getProduct(String code) {
        return products.get(code);
    }

    public Map<String, Product> getAllProducts() {
        return new HashMap<>(products); // Defensive copy
    }
}
