import java.util.LinkedList;
import java.util.Queue;

public class MoveZeros {

    public static void bruteForce(int[] nums) {
        if (nums.length <= 1) return;

        Queue<Integer> queue = new LinkedList<>();

        for (int num : nums) {
            if (num != 0) {
                queue.add(num);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void optimizedSolution(int[] nums) {
          if (nums.length == 1) return;
          int left=0;
          for(int right=0; right<nums.length; right++) {
               if (nums[right] != 0) {
                    nums[left] = nums[right];
                    left++;
               }
          }
          for(int i=left; i< nums.length; i++) {
               nums[i] = 0;
          }
    }
}
