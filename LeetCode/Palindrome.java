import java.util.stream.IntStream;

public class Palindrome {
     /**
     * Checks if an integer is a palindrome using the most efficient mathematical
     * half-reversal method, avoiding String conversion and explicit overflow checks.
     * * @param x The integer to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int x) {
        // Case 1: Negative numbers are not palindromes.
        // Case 2: Numbers ending in 0 (like 10, 200) are not palindromes, 
        //         unless the number is 0 itself.
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;

        // We only reverse the first half of the number.
        // The loop stops when 'reversed' is greater than 'x' (halfway point).
        while (x > reversed) {
            // Get the last digit
            int lastDigit = x % 10;
            
            // Append digit to reversed number
            reversed = reversed * 10 + lastDigit;
            
            // Remove the last digit from x
            x /= 10;
        }

        // Compare original number (x is now the first half) with the reversed half.
        // For even-digit length numbers (e.g., 1221), x == reversed.
        // For odd-digit length numbers (e.g., 12321), the middle digit is discarded from the reversed half: x == reversed / 10.
        return (x == reversed) || (x == reversed / 10);
    } 

    public static boolean isPalindromeStreamOneLine(int x) {
     String s = x + "";
     return IntStream.range(0, s.length()/2)
               .allMatch(i -> s.charAt(i) == s.charAt(s.length()-i-1));
     }


}
