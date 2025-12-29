import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IterableTest {
     public static void main(String[] args) {
          List<String> fruits = new ArrayList<>();

          fruits.add("Apple");
          fruits.add("Banana");
          fruits.add("Cherry");

          System.out.println(fruits);


          //By using Lambda Expression
          System.out.println("By using Lambda Expression");
          fruits.forEach(fruit -> System.out.println(fruit));

          //By using Method Reference 
          System.out.println("By using Method Reference");
          fruits.forEach(System.out::println);
          
          Iterator<String> it = fruits.iterator();
          
          while (it.hasNext()) {
               String nextFruit = it.next();
               if ("Banana".equals(nextFruit)) {
                    it.remove();
               }
          }
          System.out.println(fruits);

          System.out.println("New way to print elements : ");
          
          Iterator<String> updatedIt = fruits.iterator();
          updatedIt.forEachRemaining(item -> System.out.println(item));
          
     }
}