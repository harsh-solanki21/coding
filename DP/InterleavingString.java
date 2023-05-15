package DP;

public class InterleavingString {

    // https://leetcode.com/problems/interleaving-string/

    // Memoization
    static boolean isInterleaveMemoize(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];
        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                        (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return matrix[s2.length()][s1.length()];
    }


    // Tabulation
    static boolean isInterleaveTabulation(String s1, String s2, String s3) {
        int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();

        if (s3Len != (s1Len + s2Len)) {
            return false;
        }

        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;

        // first row
        for (int i = 1; i <= s2Len; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }
        }

        //first column
        for (int j = 1; j <= s1Len; j++) {
            if (s3.charAt(j - 1) == s1.charAt(j - 1) && dp[j - 1][0]) {
                dp[j][0] = true;
            } else {
                dp[j][0] = false;
            }
        }

        for (int row = 1; row <= s1Len; row++) {
            int k = row;
            for (int col = 1; col <= s2Len; col++) {
                if (s3.charAt(k) == s1.charAt(row - 1) && dp[row - 1][col]) {
                    dp[row][col] = true;
                } else if (s3.charAt(k) == s2.charAt(col - 1) && dp[row][col - 1]) {
                    dp[row][col] = true;
                } else {
                    dp[row][col] = false;
                }
                k++;
            }
        }

        return dp[s1Len][s2Len];
    }


    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";  // true
        String str1 = "aabcc", str2 = "dbbca", str3 = "aadbbbaccc";  // false

//        System.out.println(isInterleaveMemoize(s1, s2, s3));
//        System.out.println(isInterleaveTabulation(s1, s2, s3));

        System.out.println(isInterleaveMemoize(str1, str2, str3));
        System.out.println(isInterleaveTabulation(str1, str2, str3));
    }

}
