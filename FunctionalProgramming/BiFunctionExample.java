import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        // BiFunction to add two integers
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

        // Apply the BiFunction
        Integer sum = adder.apply(5, 10);
        System.out.println("Sum: " + sum); // Output: Sum: 15

        // BiFunction to concatenate two strings
        BiFunction<String, String, String> concatenator = (s1, s2) -> s1 + " " + s2;

        // Apply the BiFunction
        String combinedString = concatenator.apply("Hello", "World");
        System.out.println("Combined String: " + combinedString); // Output: Combined String: Hello World
    }
}
