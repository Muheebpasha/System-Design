import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange","mango", "grape", "banana", "mango");

        Set<String> items = new HashSet<>();
        Set<String> duplicates = list.stream()
            .filter(n -> !items.add(n))
            .collect(Collectors.toSet());

        System.out.println("Duplicates: " + duplicates);
    }
}

