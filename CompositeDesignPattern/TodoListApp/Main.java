public class Main {

    public static void main(String[] args) {
        TodoList mainList = new TodoList("Today's Tasks");

        TodoItem task1 = new TodoItem("Learn Composite Design Patterns");
        TodoItem task2 = new TodoItem("Learn Decorative Design Patterns");

     


        TodoList subList = new TodoList("Homework");
        
        subList.add(new TodoItem("Practise example"));
        subList.add(new TodoItem("Solve Real world Problems"));
           
        mainList.add(task1);
        mainList.add(task2);
        mainList.add(subList);
            
        mainList.display();
    }
}