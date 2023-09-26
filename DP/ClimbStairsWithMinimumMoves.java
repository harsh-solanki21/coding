package DP;

public class ClimbStairsWithMinimumMoves {

    // https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=5

    // Tabulation
    static int minimumMoves(int[] nums, Integer[] dp) {
        dp[nums.length] = 0;  // but moves to go 6 to 6 is 0 (because we don't need to move to go 6 from 6)
        // steps to go 6 to 6 is 1 (that step is don't move)
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = null;
                }
            }
        }
        return dp[0];  // returns minimum moves to climb stairs from 0th step to 10th step
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        System.out.println(minimumMoves(nums, new Integer[nums.length + 1]));
    }

}
