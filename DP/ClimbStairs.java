package DP;

public class ClimbStairs {

    // Memoization
    static int climbStairsMemoize(int n, int[] dp) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        int path1 = climbStairsMemoize(n - 1, dp);
        int path2 = climbStairsMemoize(n - 2, dp);
        int path3 = climbStairsMemoize(n - 3, dp);
        dp[n] = path1 + path2 + path3;

        return dp[n];
    }


    // Tabulation
    static int climbStairsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }


    // Space Optimization
    static int climbStairsSpace(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int prev0 = 1, prev1 = 1, prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev0 + prev1 + prev2;
            prev0 = prev1;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsMemoize(n, new int[n + 1]));
        System.out.println(climbStairsTab(n));
        System.out.println(climbStairsSpace(n));
    }

}
