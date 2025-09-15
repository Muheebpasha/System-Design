import java.util.ArrayList;
import java.util.List;

// Composite class
class Menu implements MenuComponent {
    private String name;
    private List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        menuComponents.add(component);
    }

    public void remove(MenuComponent component) {
        menuComponents.remove(component);
    }

    public void display() {
        System.out.println("*****************");
        System.out.println("Menu: " + name);
        System.out.println("*****************\n");
        for (MenuComponent component : menuComponents) {
            component.display();
        }
    }
}
