import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

class Product {
    private String name;
    private double price;
    private String deliveryDate; // in dd-MM-yyyy

    public Product(String name, double price, String deliveryDate) {
        this.name = name;
        this.price = price;
        this.deliveryDate = deliveryDate;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDeliveryDate() { return deliveryDate; }
}

public class ProductStreamDemo {
     public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Laptop", 75000, "21-06-1993"),
                new Product("Phone", 35000, "10-08-2024"),
                new Product("Watch", 4999, "05-01-2022")
        );

        DateTimeFormatter inFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        List<String> result = products.stream()
                .map(p -> {
                    String formattedDate = LocalDate
                            .parse(p.getDeliveryDate(), inFormat)
                            .format(outFormat);

                    String formattedPrice = "Rs " + p.getPrice();

                    return p.getName() + " | " + formattedPrice + " | " + formattedDate;
                })
                .toList();

        result.forEach(System.out::println);

    }
}
