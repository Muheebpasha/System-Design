import java.util.stream.IntStream;
import java.util.stream.Collectors;
public class ReverseString {

     public static void twoPointer(char[] s) {
          int left = 0, right = s.length - 1;
          while (left < right) {
               char temp = s[left];
               s[left] = s[right];
               s[right] = temp;
               left++;
               right--;
          }
     }

     public static String reverse(char[] s) {
        return IntStream.range(0, s.length)
                .mapToObj(i -> s[s.length - 1 - i])
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
     
}
