package DP;

public class FrogJump2 {

    // Followup problem of Frog Jump Problem
    // Instead of n-1 and n-2 jumps, now frog can jump till k steps

    // Recursion
    // TC - O(k^n), SC - O(n)
    static int frogJump2(int[] heights, int k, int n) {
        if (n == 0) {
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int jump = frogJump2(heights, k, n - i) + Math.abs(heights[n] - heights[n - i]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return minSteps;
    }


    // Memoization
    // TC - O(k * n), SC - O(n)
    static int frogJump2Memoize(int[] heights, int[] dp, int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int jump = frogJump2Memoize(heights, dp, k, n - i) + Math.abs(heights[n] - heights[n - i]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        dp[n] = minSteps;
        return dp[n];
    }


    // Tabulation
    // TC - O(n * k), SC - O(n)
    static int frogJump2Tabulation(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }


    // Space Optimize
    // TC - O(n * k), SC - O(k)
    // Worst case Time Complexity will be O(n), so Space optimization will be same as Tabulation.


    public static void main(String[] args) {
        int[] heights = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k = 4, n = heights.length;

        System.out.println(frogJump2(heights, k, n - 1));
        System.out.println(frogJump2Memoize(heights, new int[n + 1], k, n - 1));
        System.out.println(frogJump2Tabulation(heights, k));
    }

}
