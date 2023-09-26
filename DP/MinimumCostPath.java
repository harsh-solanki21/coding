package DP;

public class MinimumCostPath {

    // Tabulation
    static int minimumCostPath(int[][] nums, int[][] dp) {
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = nums[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + nums[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + nums[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + nums[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {2, 8, 4, 1, 6, 4, 2},
                {6, 0, 9, 5, 3, 8, 5},
                {1, 4, 3, 4, 0, 6, 5},
                {6, 4, 7, 2, 4, 6, 1},
                {1, 0, 3, 7, 1, 2, 7},
                {1, 5, 3, 2, 3, 0, 9},
                {2, 2, 5, 1, 9, 8, 2}
        };
        System.out.println(minimumCostPath(nums, new int[nums.length][nums[0].length]));
    }

}
