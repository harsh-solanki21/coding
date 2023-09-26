package DP;

public class LongestPalindromicSubstring {

    // https://www.interviewbit.com/blog/longest-palindromic-substring/

    // Brute force Approach
    // TC - O(n^3), SC - O(1)
    static int longestPalindromeBF(String s) {
        int maxLength = 1, start = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = 0;
                    }
                }

                // Palindrome
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return maxLength;
    }


    // Efficient Approach - DP
    // TC - O(n^2), SC - O(n^2)
    static int longestPalindromeDP(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int len = s.length(), longestPalindromeStart = 0, longestPalindromeLength = 1;
        boolean[][] state = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            state[i][i] = true; // dist = 0.
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int dist = 1; dist < len - i; dist++) {
                int j = dist + i;
                state[i][j] = (dist == 1) ? s.charAt(i) == s.charAt(j) : (s.charAt(i) == s.charAt(j)) && state[i + 1][j - 1];
                if (state[i][j] && j - i + 1 > longestPalindromeLength) {
                    longestPalindromeLength = j - i + 1;
                    longestPalindromeStart = i;
                }
            }
        }

        return longestPalindromeLength;
    }


    // Expand Around Center Approach
    // TC - O(n^2), SC - O(1)
    static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s.length();
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return end - start + 1;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    // Manacher's Algorithm does this in linear time. See the solution in String section.


    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(longestPalindromeBF(s));
        System.out.println(longestPalindromeDP(s));
        System.out.println(longestPalindrome(s));
    }

}
