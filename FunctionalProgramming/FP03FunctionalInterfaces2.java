import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BiPredicate;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.Random;

public class FP03FunctionalInterfaces2 {
    public static void main(String[] args) {
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier.get());
        
        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));
        
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
          return number<10 && str.length() > 5;
        };
        
        System.out.println(biPredicate.test(7,"Muheeb"));
        
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
          return number + " " + str;
        };
        
        System.out.println(biFunction.apply(786,"Say Bismillah"));
        
        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(123,"MuheebTechnicals");
        
        BinaryOperator<Integer> add = (a, b) -> a + b;

        int sum = add.apply(10, 20);
        System.out.println("Sum: " + sum);  
        
        IntBinaryOperator addition = (a, b) -> a + b;

        int result = addition.applyAsInt(10, 20);
        System.out.println("Primitive Sum: " + result);
        
        
    }
}

