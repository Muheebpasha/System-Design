import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

          public List<String> usingStream(int n) {
                return IntStream.rangeClosed(1, n)
               .mapToObj(curr -> {
                    if (curr%3 == 0 && curr%5 == 0) return "FizzBuzz";
                    else if (curr % 3 == 0) return "Fizz";
                    else if (curr % 5 == 0) return "Buzz";
                    else return String.valueOf(curr);
               })
               .collect(Collectors.toList());
          }
       
          public List<String> bruteForce(int n) { 
               List<String> list = new ArrayList<>();
               for (int curr = 1; curr <= n; curr++) {
                    if (curr%3 == 0 && curr%5 == 0) {
                         list.add("FizzBuzz");
                    }
                    else if (curr%3 == 0) {
                         list.add("Fizz");
                    } else if(curr%5 == 0) {
                         list.add("Buzz");
                    } else {
                         list.add(String.valueOf(curr));
                    }
               }
               return list;
               // TC : O(n) and SC : O(1)
          }
}