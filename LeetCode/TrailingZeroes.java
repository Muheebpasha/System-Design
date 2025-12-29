import java.util.stream.IntStream;

public class TrailingZeroes {
     public static int trailingZeroes(int n) {
          int count=0;
          int currPowerOfFive=5;
          while (n>=currPowerOfFive) {
               count += (n/currPowerOfFive);
               currPowerOfFive *=5;              
          }
          return count;
     }

     public static int trailingZeroesUsingStream(int n) {
          return IntStream.iterate(5, i->i<=n,i->i*5).map(i->n/i).sum();
     }
     
}
