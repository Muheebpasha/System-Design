public class StringLengthOfLastWord {
    //    TC : O(n) and SC : O(1)
    public static int optimizedApproach(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (right>=0 && s.charAt(right) == ' ') {
            right--;
        }
        left=right;
        while (left<=right && s.charAt(left) != ' ') {
            left--;
        }
        return  right - left;
    }
    public static String printLastWord(String s) {
        int right = s.length()-1;
        int left = 0;

        // Skip trailing spaces
        while (right>=0 && s.charAt(right) == ' ') {
            right--;
        }
        left=right;

        // Move left until space or start
        while (left>=0 && s.charAt(left) != ' ') {
            left--;
        }

        String result="";
        for (int i=left+1; i<=right; i++) {
            result += s.charAt(i);
        }
        return result;
    }
    static void main() {
        String str= "Java is Powerful";
        System.out.println("Last word of the String is : "+printLastWord(str));
        System.out.println("Last word length of the String is : " +optimizedApproach(str));

    }
}
