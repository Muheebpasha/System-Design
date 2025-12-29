import java.util.Arrays;

public class Main {
     public static void main(String[] args) {
          
          int[] testArr = {7,8,0,9,7,0,0,1,2,0,0,5,0,6,0};
          MoveZeros.optimizedSolution(testArr);
          System.out.println(Arrays.toString(testArr));


          int[] sortedArr = {1,2,3,5,7,9,10,11,13,14,15};
          System.out.println(Arrays.toString(sortedArr) + " find target 14 : Found at index : "+BinarySearch.search(sortedArr, 14));

          System.out.println(Arrays.toString(sortedArr) + " find target 14 : Found at index : "+BinarySearch.rotatedSortedSearch(sortedArr, 14));
          
          int[] rotatedArr = {7,8,9,1,2,3,4};
          System.out.println(Arrays.toString(rotatedArr) + " find target 3 : Found at index : "+BinarySearch.rotatedSortedSearch(rotatedArr,3));

          System.out.println(Arrays.toString(rotatedArr) + " Array Min Value is : "+BinarySearch.findMin(rotatedArr));

          int[] myarr = {7,8,9,1,2,3,4};
          System.out.println(Arrays.toString(myarr) +" target sum is 10 then two index are " + Arrays.toString(TwoSum.bruteforce(myarr, 10)));
          System.out.println(Arrays.toString(myarr) +" target sum is 10 then two index are " + Arrays.toString(TwoSum.optimizedSolution(myarr, 10)));

          FizzBuzz fizzBuzz = new FizzBuzz();
          System.out.println(fizzBuzz.bruteForce(15));
          System.out.println(fizzBuzz.usingStream(30));

          SingleNumber singleNumber = new SingleNumber();
          //singleNumber.streamSolution(new int[]{7, 3, 5, 3, 7, 9, 5})// ✅ Valid
          int[] nums = new int[]{7, 3, 5, 3, 7, 9, 5};
          System.out.println(singleNumber.streamSolution(nums));
          System.out.println(singleNumber.bruteForce(nums));
          System.out.println(singleNumber.streamXor(nums));
          System.out.println(singleNumber.optimizedSolutionXor(nums));

          int num3 = 1234321;
          System.out.println("Is " + num3 + " a palindrome? " + Palindrome.isPalindrome(num3)); // Expected: true

          int num1 = 12321;
          int num2 = -12321;

          // Test Case 1: 12321
          boolean result1 = Palindrome.isPalindrome(num1);
          System.out.println("Is " + num1 + " a palindrome? " + result1); // Expected: true

          // Test Case 2: -12321
          boolean result2 = Palindrome.isPalindrome(num2);
          System.out.println("Is " + num2 + " a palindrome? " + result2); // Expected: false
          
          // Additional Test Cases
          System.out.println("Is 121 a palindrome? " + Palindrome.isPalindromeStreamOneLine(121)); // Expected: true
          System.out.println("Is 123 a palindrome? " + Palindrome.isPalindromeStreamOneLine(123)); // Expected: false
          System.out.println("Is 10 a palindrome? " + Palindrome.isPalindromeStreamOneLine(10));   // Expected: false (ends with 0)

          System.out.println("Trailing Zero for 125! : " + TrailingZeroes.trailingZeroesUsingStream(125));
          System.out.println("Trailing Zero for 20! : " + TrailingZeroes.trailingZeroes(20));

          System.out.println("Reverse Interger for 47179 is : " + ReverseInteger.optimizedReverse(47179));

          double result =  Power.myPow(2, 10);
          System.out.println("Power(2, 10) : " + result);

        System.out.println(RomanToInteger.convertRomanToInt("III"));     // 3
        System.out.println(RomanToInteger.convertRomanToInt("IX"));      // 9
        System.out.println(RomanToInteger.streamRomanToInt("LVIII"));   // 58
        System.out.println(RomanToInteger.streamRomanToInt("MCMXCIV")); // 1994
          
        char[] s = {'h','e','l','l','o'};
        ReverseString.twoPointer(s); // reverse in place
        System.out.println("Reverse string is : " + new String(s));

        System.out.println("Reverse string is : " + ReverseString.reverse(s));

        System.out.println("RepeatedDNASequences for String AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT :  " +RepeatedDNASequences.usingSets("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        System.out.println("Is anagram : " + Anagram.isAnagram("muheeb", "beehum"));

        System.out.println("Longest Palindrome of substring babad : "+LongestPalindromeSubstring.longestPalindrome("babad"));

        String str = "Muheeb Loves Java Programming";
        ReverseWordsString reverseWordsString = new ReverseWordsString();
        
     
        System.out.println(str + " Reverse is " + reverseWordsString.reverseWords(str));

        
     }
}
