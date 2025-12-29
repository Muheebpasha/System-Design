import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonLongestPrefix {
     // TC: O(m*n) SC: O(1)
     public String optimizeApproach(String[] strs) {
		if(strs.length == 0) return "";
		String prefix = strs[0];
		for(int i=1; i<strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() -1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}

      public String usingStream(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String first = strs[0];

        int prefixLength = IntStream.range(0, first.length())
                .takeWhile(i ->
                        strs.length == (int) java.util.Arrays.stream(strs)
                                .filter(s -> i < s.length() && s.charAt(i) == first.charAt(i))
                                .count()
                )
                .map(i -> 1)
                .sum();

        return first.substring(0, prefixLength);
    }

     public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        return Arrays.stream(strs)
                .reduce((a, b) -> {
                    int i = 0;
                    while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
                        i++;
                    }
                    return a.substring(0, i);
                })
                .orElse("");
    }
}
