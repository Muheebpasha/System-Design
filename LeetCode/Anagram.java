public class Anagram {
     public static boolean isAnagram(String s, String t) {
          if (s.length() != t.length()) {
               return false;
          }
          //For lowercase 'a' to 'z'
          int[] freq = new int[26];
          // increament for s and decrement for t
          for(int i=0; i<s.length(); i++) {
               freq[s.charAt(i) - 'a']++;
               freq[s.charAt(i) - 'a']--;
          }

          // If all counts are zero, It's an anagram
          for(int count : freq) {
               if (count != 0) {
                    return false;
               }
          }

          return true;
     }
     
}
