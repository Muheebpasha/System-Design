import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
     public static List<String> usingSets(String s) {
          Set<String> set = new HashSet<>();
          Set<String> list = new HashSet<>();

          for(int i=0; i<=s.length()-10; i++) {
               String subString = s.substring(i, i+10);
               if (set.contains(subString)) {
                    list.add(subString);
               } else {
                    set.add(subString);
               }
          }
          return new ArrayList<>(list);
     }
}
