import java.util.function.BiPredicate;

class BiPredicateExample {
    public static void main(String[] args) {
        // A BiPredicate that checks if two strings have the same length
        BiPredicate<String, String> areSameLength = (s1, s2) -> s1.length() == s2.length();

        System.out.println(areSameLength.test("apple", "banana")); // Output: false
        System.out.println(areSameLength.test("cat", "dog"));     // Output: true
    }
}
