package DP;

public class UniquePaths {

    // https://leetcode.com/problems/unique-paths/

    static public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = helper(dp, 0, 0, m, n);
        return dp[0][0];
    }

    private static int helper(int[][] dp, int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = helper(dp, i + 1, j, m, n) + helper(dp, i, j + 1, m, n);
        return dp[i][j];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

}
