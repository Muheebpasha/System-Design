public class Product implements ProductComponent {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display(int depth) {
       System.out.println("  ".repeat(depth) + "- Product: " + name + " | Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}
