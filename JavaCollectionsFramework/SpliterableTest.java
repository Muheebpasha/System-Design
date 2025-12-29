import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliterableTest {
     public static void main(String[] args) {
          List<Integer> evenNum = new ArrayList<>();
          for(int i=1; i<=50; i++) {
               evenNum.add(i*2);
          }

          System.out.println(evenNum);

          Spliterator<Integer> mySpliterator = evenNum.spliterator();
          System.out.println(" mySpliterator evenNum.spliterator() value is :"+mySpliterator.estimateSize());

          Consumer<Integer> a = x -> System.out.println("mySpliterator.forEachRemaining = " + x);
          // mySpliterator.forEachRemaining(a);

          

          //for(Spliterator<Integer> mySpliterator2 = evenNum.spliterator(); mySpliterator2.tryAdvance(a); );

          Spliterator<Integer> secondHalf = evenNum.spliterator();
          Spliterator<Integer> firstHalf = secondHalf.trySplit();

          firstHalf.forEachRemaining(element -> System.out.println(element));
          secondHalf.forEachRemaining(element -> System.out.println(element));
     }
}
