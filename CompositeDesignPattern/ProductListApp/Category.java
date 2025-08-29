import java.util.ArrayList;
import java.util.List;

public class Category implements ProductComponent {

    private String name;
    private List<ProductComponent> items = new ArrayList<>();


    public Category(String name) {
        this.name = name;
    }

    public void add(ProductComponent item) {
        items.add(item);
    }

    public void remove(ProductComponent item) {
        items.remove(item);
    }

    @Override
    public void display(int depth) {
        System.out.println("  ".repeat(depth) + "Category: " + name);
        for (ProductComponent item : items) {
            item.display(depth + 1);
        }
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (ProductComponent item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
}
