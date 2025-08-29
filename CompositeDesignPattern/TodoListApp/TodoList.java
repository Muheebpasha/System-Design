import java.util.ArrayList;
import java.util.List;

public class TodoList implements TodoComponent {
    private String name;
    private List<TodoComponent> items = new ArrayList<>();
    
    public TodoList(String name) {
        this.name = name;
    }

    public void add(TodoComponent item) {
        items.add(item);
    } 

    public void remove(TodoComponent item) {
        items.remove(item);
    }
    @Override
    public void display() {
       System.out.println("List: "+ name);
       for(TodoComponent item : items) {
            item.display();
       }    
    }
}