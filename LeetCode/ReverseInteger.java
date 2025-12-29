public class ReverseInteger {
     public static int optimizedReverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int reversed = 0;
        
        while (x != 0) {
            int lastDigit = x % 10;

            // Check overflow BEFORE multiplication
            if (reversed > max / 10 || reversed < min / 10) {
                return 0;
            }

            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        return reversed;
    }   
}
