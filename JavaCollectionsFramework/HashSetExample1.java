import java.util.HashSet;

public class HashSetExample1 {
  public static void main(String[] args) {
    HashSet<String> fruits = new HashSet<>();
    
    //Add Elements
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Mango");
    fruits.add("Orange");
    fruits.add("Apple"); // duplicate — ignored

    System.out.println("Fruits: " + fruits);
  }
}
