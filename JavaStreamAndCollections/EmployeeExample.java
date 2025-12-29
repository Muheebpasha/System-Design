import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + name + " - ₹" + price;
    }
}

public class EmployeeExample {
    public static void main(String[] args) {

        // Create a list of products
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(101, "Laptop", 55000),
                new Product(102, "Mobile", 20000),
                new Product(103, "Laptop", 60000), // duplicate
                new Product(104, "Tablet", 25000),
                new Product(105, "Laptop", 65000)  // duplicate
        ));

        // Search first occurrence of "Laptop"
        int pos = -1;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.equals("Laptop")) {
                pos = i;
                break;
            }
        }

        if (pos != -1) {
            Product p = products.get(pos);
            System.out.println("First Laptop found at index: " + pos);
            System.out.println("Product Details: " + p);
        } else {
            System.out.println("Laptop not found!");
        }
    }
}

