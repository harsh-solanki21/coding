package DP;

public class MinCostClimbingStairs {

    // https://leetcode.com/problems/min-cost-climbing-stairs/

    // Space Optimization
    // TC - O(n), SC - O(1)
    static int minCost(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return Math.min(prev1, prev2);
    }


    // Tabulation
    // TC - O(n), SC - O(n)
    static int minCostToClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }


    // Memoization
    // TC - O(n), SC - O(n) + O(n)   n for dp array and other n for stack calls
    static int solve(int[] cost, int n, int[] dp) {
        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
        return dp[n];
    }

    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length + 1];
        return Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
    }


    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
//        System.out.println(minCostClimbingStairs(cost));  // Memoize
//        System.out.println(minCostToClimbingStairs(cost));  // Tabulation
        System.out.println(minCost(cost));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        System.out.println(minCostClimbingStairs(cost2));  // Memoize
//        System.out.println(minCostToClimbingStairs(cost2));  // Tabulation
        System.out.println(minCost(cost2));
    }

}
