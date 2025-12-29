import java.util.Arrays;
import java.util.stream.IntStream;

class CommonSuffix {
    public static String commonSuffix(String[] words) {

        return IntStream.range(0, words[0].length())
                .mapToObj(i -> words[0].substring(words[0].length() - 1 - i))
                .takeWhile(suf -> Arrays.stream(words).allMatch(s -> s.endsWith(suf)))
                .reduce((a, b) -> b)
                .orElse("");
    }

    public static void main(String[] args) {
        String[] mystrings = {"walking", "talking", "barking"};

        System.out.println("Common Suffix for strings:");
        System.out.println(Arrays.toString(mystrings));
        System.out.println("Result: " + commonSuffix(mystrings));
    }
}

