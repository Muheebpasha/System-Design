import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductStream {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 50000),
            new Product("Mouse", 500),
            new Product("Keyboard", 800)
        );

        // Filter products with price > 1000
        List<String> expensiveProductNames = products.stream()
            .filter(p -> p.price > 1000)
            .map(p -> p.name)
            .collect(Collectors.toList());

        System.out.println(expensiveProductNames); // Output: [Laptop]
    }
}

