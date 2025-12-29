import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 3, "B", 1, "C", 2);

        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,       // merge function in case of key collision
                LinkedHashMap::new    // preserve insertion order
            ));

        System.out.println(sortedMap);  // Output: {B=1, C=2, A=3}
    }
}

