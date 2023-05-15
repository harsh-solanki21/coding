package DP;

public class Goldmine {

    static int goldmine(int[][] nums, int[][] dp) {
        for (int j = nums[0].length - 1; j >= 0; j--) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (j == nums[0].length - 1) {
                    dp[i][j] = nums[i][j];
                } else if (i == 0) {
                    dp[i][j] = nums[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == nums.length - 1) {
                    dp[i][j] = nums[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = nums[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }
            }
        }

        int maxGold = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}};

        System.out.println(goldmine(nums, new int[nums.length][nums[0].length]));
    }

}
