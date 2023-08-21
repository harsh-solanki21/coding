package Arrays;

public class LongestPalindrome {

    static int longestPalindrome(String s) {
        int[] charCount = new int[123];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)]++;
        }

        int newStrLen = 0;
        boolean hasOdd = false;
        for (int i = 0; i < charCount.length; i++) {
            int count = charCount[i];
            if (count % 2 != 0) {
                hasOdd = true;
                newStrLen += (count - 1);
            } else {
                newStrLen += count;
            }

        }

        return hasOdd ? newStrLen + 1 : newStrLen;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaAaaaa"));
        System.out.println(longestPalindrome("abccccdd"));
    }

}
