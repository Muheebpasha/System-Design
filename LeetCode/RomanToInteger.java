import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RomanToInteger {
     public static int convertRomanToInt(String s) {

          Map<Character, Integer> map = new HashMap<>();

          map.put('I', 1);
          map.put('V', 5);
          map.put('X', 10);
          map.put('L', 50);
          map.put('C', 100);
          map.put('D', 500);
          map.put('M', 1000);

          int result = 0;
          int n = s.length();

          for(int i=0; i<n; i++) {
               if (i < n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1)) ) {
                    result -= map.get(s.charAt(i));
               } else {
                    result += map.get(s.charAt(i));
               }
          }
          return result;
     }
     // TC: 0(n) , SC: 0(1)

     public static int streamRomanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return IntStream.range(0, s.length())
                .map(i -> {
                    int curr = map.get(s.charAt(i));
                    int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
                    return curr < next ? -curr : curr;
                })
                .sum();
    }
}
