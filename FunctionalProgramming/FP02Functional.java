import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
    System.out.println("Numbers List :"+numbers);
    //int sum = addListFunctional(numbers);
    //System.out.println("Sum is "+sum);
    
    List<Integer> squareNumbers = doubleList(numbers);
    
    System.out.println("Square Number List : "+squareNumbers);
    
    List<Integer> evenNumbers = evenNumbersList(numbers);
    System.out.println("Even Number List : "+evenNumbers);
  }
  
  private static List<Integer> evenNumbersList(List<Integer> numbers) {
    return numbers.stream().filter(x->x%2 == 0).collect(Collectors.toList());
  }
  
  private static List<Integer> doubleList(List<Integer> numbers) {
    return numbers.stream().map(x->x*x).collect(Collectors.toList());
  }
  
  private static int sum(int aggregate,int nextNumber) {
    System.out.println(aggregate +" + "+ nextNumber);
    return aggregate + nextNumber;
  }
  private static int addListFunctional(List<Integer> numbers) {
    return numbers.stream()
            .reduce(0, Integer::sum);
           // .reduce(0, (x,y) -> x+y);
          //.reduce(0, FP02Functional::sum);
  }
  
}
