import java.util.List;
import java.util.stream.Collectors;

public class FP01Excercises {
  public static void main(String args[]) {
    List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","AZURE","Docker","Kubernetes","GIT");
    
    courses.stream()
      .map(course -> course + " - " + course.length())
      .forEach(System.out::println);
    
    /*
      courses.stream()
      .filter(course->course.length() >= 4) // Filter the courses containing 4 or more than 4 characters.
      .forEach(System.out::println);
      */
    
    //courses.stream()
      //.filter(c->c.contains("Spring")) //Filter the courses containing only "Spring"
      //.forEach(System.out::println);
      
    //courses.stream()
      //.forEach(System.out::println);
      
  
      
    //List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
    //printOddNumbersInList(numbers);
    //printCubeOfOddNumbersInList(numbers);
    
  }
  private static void printCubeOfOddNumbersInList(List<Integer> numbers) {
    numbers.stream()
      .filter(n->n%2 == 1)
      .map(n->n*n*n)
      .forEach(System.out::println);
  }
  private static void printOddNumbersInList(List<Integer> numbers) {
    numbers.stream()
      .filter(n -> n%2 == 1)
      .forEach(System.out::println);
  }
}
