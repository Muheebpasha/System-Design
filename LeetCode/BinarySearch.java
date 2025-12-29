public class BinarySearch {
     public static int search(int[] nums,int target) {
          int low = 0;
          int high = nums.length -1;
          while (low<=high) {
               int mid = (low + high) / 2;
               if (nums[mid] == target) {
                    return mid;
               }
               if (nums[mid] < target) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }
          return -1;
     } 
     public static int rotatedSortedSearch(int[] nums, int target) {
          int left = 0;
          int right = nums.length -1 ;

          while (left<right) {
               int mid = left + (right - left) / 2;
               if (nums[mid] == target) 
                    return mid;
               if (nums[left] <= nums[mid]) {      
                    if (nums[left] < target && target <= nums[mid]) 
                         right = mid - 1;
                    else 
                         left = mid + 1;
               } else {
                    if (nums[mid] < target && target <= nums[right]) 
                         left = mid + 1;
                    else 
                         right = mid - 1;
               }
          } 
          return -1;
     }

     public static int findMin(int[] nums) {
          if (nums.length == 1) {
               return nums[0];
          }
          if (nums.length == 2) {
               return Math.min(nums[0],nums[1]);
          }
          if (nums[0] < nums[nums.length -1]) {
               return nums[0];
          }
          int left = 0;
          int right = nums.length - 1;
          while (left < right) {
               int mid = left + (right - left)/2;
               // nums = [3,4,5,1,2] mid= 2 => nums[mid] 5
               // => (nums[2] > nums[3]) => (5>1) => true

               if (nums[mid] < nums[mid + 1]) {
                    return nums[mid+1];
               }
               // nums = [4,5,1,2,3], mid = 2 => nums[mid] = 1
               // => (nums[1] > nums[2]) => 5 > 1 => true
               if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
               }
              
               if(nums[left] < nums[mid])
                    left = mid + 1;
               else
                    right = mid - 1; // right = 2-1 => 1 
          }
          return 0;
     }
     
}
