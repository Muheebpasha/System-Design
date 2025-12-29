import java.util.stream.LongStream;

public class FP05Parallezing {

     public static void main(String[] args) {
          long time = System.currentTimeMillis();
          System.out.println(LongStream.range(0, 1000000).sum());
          System.out.println(LongStream.range(0, 1000000).parallel().sum());
          System.out.println(System.currentTimeMillis() -time);
     }
}