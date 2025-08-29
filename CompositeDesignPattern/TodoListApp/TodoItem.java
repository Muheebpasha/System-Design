public class TodoItem implements TodoComponent {
    private String description;

    public TodoItem(String description) {
        this.description = description;
    }

    @Override
    public void display() {
        System.out.println("Task: " + description);        
    }
}