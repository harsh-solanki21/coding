package String;

public class BreakPalindrome {

    // https://leetcode.com/problems/break-a-palindrome/

    static String breakPalindrome(String palindrome) {
        char[] charArray = palindrome.toCharArray();
        int len = palindrome.length();
        if (len < 2)
            return "";

        for (int i = 0; i < len / 2; i++) {
            if (charArray[i] - 'a' > 0) {
                charArray[i] = 'a';
                return String.valueOf(charArray);
            }
        }

        charArray[len - 1] = 'b';
        return String.valueOf(charArray);
    }


    public static void main(String[] args) {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));
    }

}
