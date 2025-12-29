import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
     //TC : O(n) and SC: O(1)
     public int streamXor(int[] nums) {
          return Arrays.stream(nums)
               .reduce(0, (a, b) -> a ^ b);
     }

     public int optimizedSolutionXor(int[] nums) {
          int singleNum = 0;
          for(int num :nums) {
               singleNum = singleNum ^ num;
          }
          return singleNum;
     }

     public int streamSolution(int[] nums) {
          return (int) Arrays.stream(nums)
                    .collect(
                         HashSet::new,
                         (set, n) -> {
                              if (set.contains(n)) set.remove(n);
                              else set.add(n);
                         },
                         HashSet::addAll
                    )
                    .iterator().next();
     }

     public int bruteForce(int[] nums) {

          // TC: O(n) and SC: O(n)
          if (nums.length == 1) {
               return nums[0];
          }
          Set<Integer> set = new HashSet<>();
          for(int i=0;i<nums.length; i++) {
               if (set.contains(nums[i])) {
                    set.remove(nums[i]);
               } else {
                    set.add(nums[i]);
               }
          }
          return set.iterator().next();
     }
     
}
/*
✔ What is an Iterator?

An Iterator is an object that allows us to go through (iterate over) elements of a collection one by one.

✔ What is next()?
next()
This returns the next available element in the collection.
 */
