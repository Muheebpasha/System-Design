import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static boolean optimizeApprach(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static boolean findSortCompareNextSibling(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main() {
        int[] arr = {12,10,9,5,12,8};
        System.out.println("Find duplicates in given array : " + arr);
        System.out.println("Having duplicates : "+optimizeApprach(arr));
    }
}
