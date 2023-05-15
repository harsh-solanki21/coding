package DP;

public class TargetSumSubsets {

    // Total Subsets = 2^nums.length
    static boolean targetSumSubsets(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        int val = nums[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 3};
        int target = 10;
        System.out.println(targetSumSubsets(nums, target));
    }

}
