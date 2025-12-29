import java.util.HashSet;

public class HashSetExample2 {
  public static void main(String[] args) {
    HashSet<Integer> numbers = new HashSet<>();
    
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    
    //check existence
    System.out.println("Contains 20? " + numbers.contains(20));
    
    //Remove an element
    numbers.remove(10);
    
    //Size of the set
    System.out.println("Size: " + numbers.size());
    
    //Iterate over elements
    for(Integer num : numbers) {
      System.out.println(num);
    }
    
    //Clear all
    numbers.clear();
    System.out.println("After clear:" + numbers);
  }
}
