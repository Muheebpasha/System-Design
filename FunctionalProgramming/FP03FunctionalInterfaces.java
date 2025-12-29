import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class FP03FunctionalInterfaces {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
    
    Predicate<Integer> isEvenPredicate = x-> x%2 == 0;
    Function<Integer, Integer> squareFunction = x->x*x;
    Consumer<Integer> sysoutConsumer = System.out::println;
    
    numbers.stream()
      .filter(isEvenPredicate)
      .map(squareFunction)
      .forEach(sysoutConsumer);
  }

}
