import java.util.HashMap;
import java.util.Map;

public class TwoSum {
     public static int[] bruteforce(int[] nums,int target) {
          for(int i=0; i<nums.length;i++) {
               for(int j=i+1; j<nums.length;j++) {
                    if (nums[i] + nums[j] == target) {
                         return new int[]{i,j};
                    }
               }
          }
          return new int[]{};
     }

     public static int[] optimizedSolution(int[] nums, int target) {
          Map<Integer,Integer> map = new HashMap<>();
          
          for(int i=0; i<nums.length; i++) {
               int complement = target - nums[i];
               if (map.containsKey(complement)) {
                    return new int[] {map.get(complement), i};
               }
               map.put(nums[i], i);
          }
         
          return new int[]{};
     }
     // Step (i),Current Element (nums[i]),Complement (10 - nums[i]),Is Complement in Map?,Action / Map State (after step)
     //   0,             7,                       3,                       No,                           Put {7: 0}
     //   1,             8,                       2,                       No,                           "Put {7: 0, 8: 1}"
     //   2,             9,                       1,                       No,                           "Put {7: 0, 8: 1, 9: 2}"
     //   3,             1,                       9,                       Yes! (at index 2),            "Return [2, 3]"
}
