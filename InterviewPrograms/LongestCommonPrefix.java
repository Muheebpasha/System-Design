import java.util.Arrays;

class LongestCommonPrefix {
	public static String commonPrefix(String[] strs) {
		return Arrays.stream(strs)
			.reduce((a,b) -> {
				int i=0;
				while(i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
					i++;
				}
				return a.substring(0,i);
			}).orElse("");
	} 
	public static void main(String[] args) {
	  String[] strs = {"flower", "flow", "flight"};
	  System.out.println("Longest Common Prefix for String " + Arrays.toString(strs));
	  System.out.println(commonPrefix(strs));
	}
}
