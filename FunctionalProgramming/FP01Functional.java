import java.util.List;

public class FP01Functional {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
    //printAllNumbersInListFunctional(numbers);
    //printEvenNumbersInListFunctional(numbers);
    printSquareOfEvenNumbersInList(numbers);
  }
  //private static void print(int number) {
    //System.out.println(number);
  //}
  
  // number -> number%2 == 0 this is lamda expression
  private static boolean isEven(int number) {
    return number%2 == 0;
  }
  private static void printAllNumbersInListFunctional(List<Integer> numbers) {
  //What to do
    numbers.stream()
      .forEach(System.out::println);
    //.forEach(FP01Functional::print); //Method Reference
  }
  private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
    //What to do
    numbers.stream()
    //Filter - Only Allow Even Numbers
      //.filter(FP01Functional::isEven) //Filter - Only Allow Even Numbers
      .filter(number -> number%2 == 0) //Lamda Expression
      .forEach(System.out::println);
    //.forEach(FP01Functional::print); //Method Reference
  }
  private static void printSquareOfEvenNumbersInList(List<Integer> numbers) {
    numbers.stream()
      .filter(n-> n%2 == 0)
      .map(n-> n*n)
      .forEach(System.out::println);
  }
}

//Stream is a sequels of elements
