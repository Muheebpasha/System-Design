public class ReverseWordsString {

     public String reverseWords(String s) {
          char[] str = s.toCharArray();
          int left=0;
          int right=0;
          // Reverse the entire string
          reverse(str, left,right);
          // Reverse each word of the string
          reverseEachWord(str);
          // trim the extra space and return the string
          return cleanSpaces(str);
          
     }
     private void reverse(char[] str, int left,int right) {
          while (left < right) {
               char temp = str[left];
               str[left] = str[right];
               str[right] = temp;
               left++;
               right++;
          }
     }
     private void reverseEachWord(char[] str) {
          int left = 0;
          int right = 0;
          while (left < str.length) {
               while (left < str.length && str[left] == ' ') {
                  left++;  
               }
               right = left;
               while (right < str.length && str[right] != ' ') {
                    right++;
               }
               reverse(str, left, right-1);
               left=right;
          }
     }
     private String cleanSpaces(char[] str) {
          int left=0;
          int right=0;

          while (right<str.length) {
               while (right < str.length && str[right] == ' ') {
                    right++;
               }
               while (right < str.length && str[right] != ' ') {
                    str[left] = str[right];
                    left++;
                    right++;
               }
               while (right < str.length && str[right] == ' ') {
                    right++;
               }
               if (right<str.length) {
                    str[left] = ' ';
                    left++;
               }
          }
          return new String(str).substring(0,left);
     }
}
