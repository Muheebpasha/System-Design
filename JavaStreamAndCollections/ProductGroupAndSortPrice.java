import java.util.*;
import java.util.stream.Collectors;

public class ProductGroupAndSortPrice {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple iPhone", "Electronics", 25000.00));
        products.add(new Product("Nike Air Max", "Footwear", 8000.00));
        products.add(new Product("Levi's Jeans", "Clothing", 3500.00));
        products.add(new Product("Samsung TV", "Electronics", 45000.00));
        products.add(new Product("Woodland Backpack", "Accessories", 2200.00));
        products.add(new Product("Tata Tea Premium", "Grocery", 500.00));
        products.add(new Product("Ray-Ban Sunglasses", "Fashion", 7000.00));
        products.add(new Product("Dell Inspiron Laptop", "Computers", 65000.00));
        products.add(new Product("Parker Pen", "Stationery", 900.00));
        products.add(new Product("Sony Headphones", "Electronics", 15000.00));
        products.add(new Product("Adidas T-Shirt", "Clothing", 2000.00));
        products.add(new Product("HP Pavilion Laptop", "Computers", 55000.00));
        products.add(new Product("Nescafé Coffee", "Grocery", 450.00));
        products.add(new Product("Casio Watch", "Fashion", 5000.00));
        products.add(new Product("Pilot Marker", "Stationery", 150.00));

        // Group by category
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(product -> product.getCategory()));

                //.collect(Collectors.groupingBy(Product::getCategory));

        // Sort each category list by price
        groupedProducts.forEach((category, list) -> {
            list.sort(Comparator.comparingDouble(Product::getPrice)); // ascending
        });

        // Print
        groupedProducts.forEach((category, list) -> {
            System.out.println("Category: " + category);
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product Name : " + name + " , Category :" + category + " , Price :" + price;
    }
}

