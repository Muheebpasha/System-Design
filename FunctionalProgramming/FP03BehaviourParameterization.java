import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {
  public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        
        filterAndPrint(numbers, x-> x%3==0);
        
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x-> x*x);
        System.out.println("SquaredNumbers : "+ squaredNumbers);
        
        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, x-> x*x*x);
        System.out.println("cubeNumbers : "+ cubeNumbers);
        
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x-> x+x);
        System.out.println("doubledNumbers : "+ doubledNumbers);
  }
  private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer,Integer> mappingFunction) {
    return numbers.stream().map(mappingFunction).collect(Collectors.toList());
  }
  private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
    numbers.stream().filter(predicate).forEach(System.out::println);
  }
}
