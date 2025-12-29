public class Power {
     public static double myPow(double x, int n) {
          long num = Math.abs((long)n);
          double result = 1.0;

          while (num > 0) {
               if (num % 2 == 1) {
                    result *= x;
                    
               }
               x *= x;
               num /= 2;
          }
          return n < 0 ? 1.0 / result : result;
     }
     
}
