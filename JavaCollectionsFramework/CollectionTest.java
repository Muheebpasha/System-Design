import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
     public static void main(String[] args) {
          Collection<Integer> nums = new ArrayList<>();
          nums.add(1);
          nums.add(2);
          nums.add(3);
          nums.add(4);
          System.out.println(nums);
          System.out.println("Size of nums is : "+nums.size());
          System.out.println("Checking if nums contains elements or not : "+nums.isEmpty());
          System.out.println("Is  4 available in collection ? : " + nums.contains(4));
          System.out.println("Is  54 available in collection ? : " + nums.contains(54));

          //Converting collections into an array

          Integer[] arr = nums.toArray(new Integer[0]);

          System.out.println("First element of array is " + arr[0]);
          for (Integer element : arr) {
               System.out.println(element);
          }

          //Adding element to collection
          System.out.println("Does this add our element : " +nums.add(5));
          System.out.println(nums);

          // Removing element from collection
          nums.remove(4);
          System.out.println(nums);

          Collection<String> fruits = new ArrayList<>();
          fruits.add("Apple");
          fruits.add("Banana");
          fruits.add("Cherry");
          System.out.println("Fruits List : "+fruits);
          //Remove string element from the collection
          fruits.remove("Cherry");
          System.out.println(" After removing cherry: "+fruits);

          Collection<Integer> evens = new ArrayList<>();
          evens.add(2);
          evens.add(4);
          // evens.add(6);
          //checking contains all method
          System.out.println("Numbs containsAll evens : " + nums.containsAll(evens));

          //checking addAll()
          System.out.println("Adding all elements : " + nums.addAll(evens));
          System.out.println(nums);

          //Removing all elements 
          // System.out.println("Removing all elements : " +nums.removeAll(evens));

          // System.out.println(nums);

          //Removing elements based on the filter
          System.out.println("Removing filter elements : " + nums.removeIf(n -> n%2 == 0));
          System.out.println(nums);

          //Checking retainAll() returns boolean
          //It performs intersection operation on our collection
          Collection<Integer> list1 = new ArrayList<>();
          Collection<Integer> list2 = new ArrayList<>();
          
          list1.add(1);
          list1.add(2);
          list1.add(3);
          list1.add(4);

          list2.add(3);
          list2.add(4);
          list2.add(5);
          list2.add(6);

          System.out.println("List 1 values are : "+ list1);
          System.out.println("List 2 values are : "+ list2);

          System.out.println("Retain All? :"+list1.retainAll(list2));

          System.out.println("Updated list of list1 : "+list1);
          System.out.println("List 2 values are : "+ list2);

          list2.clear();
          System.out.println("Clearning list2");
          System.out.println("List 2 values are : "+ list2);

          //Checking equals methods on two collections (boolean)
          Collection list3 = new ArrayList<>();
          Collection list4 = list3;

          list3.add(3);
          list3.add(4);

          list4.add(4);
          list4.add(3);

          System.out.println("Is equal? : "+list3.equals(list4));
     }
}
