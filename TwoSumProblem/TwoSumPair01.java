import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates two different approaches to solving the Two Sum problem:
 * 1. Brute Force (O(n^2))
 * 2. Optimized using a HashSet (O(n))
 *
 * Problem: Given an array of integers and a target sum, determine if there exists
 * a pair of numbers in the array that adds up to the target.
 */

public class TwoSumPair01 {

     // --- 1. Brute Force Approach (Time Complexity: O(n^2)) ---
    
    /**
     * Checks if a pair in the array sums up to the target using nested loops.
     * This method checks every possible pair, making it inefficient for large inputs.
     *
     * @param arr The input array of integers.
     * @param target The desired sum.
     * @return true if a pair is found, false otherwise.
     */

	static boolean twoSumBruteForce(int[] arr, int target) {
        int n=arr.length;
        for(int i=0; i<n;i++) {
            for(int j=i+1; j<n; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // --- 2. Optimized Hash Set Approach (Time Complexity: O(n)) ---
    
    /**
     * Checks if a pair in the array sums up to the target using a HashSet.
     * This reduces the time complexity to O(n) by checking for the complement
     * (target - current element) in the set in O(1) time.
     * 
     *
     * @param arr The input array of integers.
     * @param target The desired sum.
     * @return true if a pair is found, false otherwise.
     */

    static boolean twoSumOptimized(int[] arr, int target) {
        // A set to store the elements we have already seen.
        Set<Integer> seenNumbers = new HashSet<>();

        // Iterate through each element in the array once.
        for (int currentNumber : arr) {
            // Calculate the required complement: complement + currentNumber = target
            int complement = target - currentNumber;

            // Check if the required complement is already in the set of seen numbers.
            // If it is, we have found a pair (complement and currentNumber).
            if (seenNumbers.contains(complement)) {
                return true;
            }

            // If the pair is not found, add the current number to the set for future lookups.
            seenNumbers.add(currentNumber);
        }

        // If the loop completes without finding a pair, return false.
        return false;
    }



    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;

        System.out.println("--- Array: {0, -1, 2, -3, 1}, Target: -2 ---");
        
        // Test Brute Force
		boolean resultBruteForce = twoSumBruteForce(arr, target); // Expected: true (-1 + -1 = -2). Wait, array only has one -1.
        // Let's check pairs: 
        // 0 + (-1) = -1
        // 0 + 2 = 2
        // 0 + (-3) = -3
        // 0 + 1 = 1
        // (-1) + 2 = 1
        // (-1) + (-3) = -4
        // (-1) + 1 = 0
        // 2 + (-3) = -1
        // 2 + 1 = 3
        // (-3) + 1 = -2  <-- Found! Pair is (-3, 1)
        System.out.println("Brute Force Result (O(n^2)): " + resultBruteForce); 
        
        // Test Optimized
        boolean resultOptimized = twoSumOptimized(arr, target);
        System.out.println("Optimized Result (O(n)): " + resultOptimized);
        
        System.out.println("\n--- Array: {3, 5, 8, 1}, Target: 10 ---");
        int[] arr2 = {3, 5, 8, 1};
        int target2 = 10;
        System.out.println("Brute Force Result (O(n^2)): " + twoSumBruteForce(arr2, target2)); // Expected: true (3 + 7? No 7. 5 + 5? No 5. 8 + 2? No 2. 9? No. Pair: (8, 2)? No. Pair: (3, 7)? No. Pair: (5, 5)? No.)
        // Pair: (3, 5)=8, (3, 8)=11, (3, 1)=4, (5, 8)=13, (5, 1)=6, (8, 1)=9. -> False.
        System.out.println("Optimized Result (O(n)): " + twoSumOptimized(arr2, target2)); // Expected: false


    }
}