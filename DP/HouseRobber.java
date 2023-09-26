package DP;

public class HouseRobber {

    // https://leetcode.com/problems/house-robber/submissions/

    static int maximumSumOfNonAdjacentElements(int[] nums) {
//        return helper(nums, nums.length - 1);

//        int[] dp = new int[nums.length + 1];
//        return helperMemoize(nums, nums.length - 1, dp);

//        return helperTabulation(nums);

        return helperSpaceOptimize(nums);
    }

    // Recursive
    // TC - O(2^n), SC - O(n)
    private static int helper(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[0];
        }

        int incl = helper(nums, i - 2) + nums[i];
        int excl = helper(nums, i - 1);

        return Math.max(incl, excl);
    }


    // Memoized
    // TC - O(n), SC - O(n) + O(n)
    private static int helperMemoize(int[] nums, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[0];
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        int incl = helper(nums, i - 2) + nums[i];
        int excl = helper(nums, i - 1);

        dp[i] = Math.max(incl, excl);
        return dp[i];
    }


    // Tabulation
    // TC - O(n), SC - O(n)
    private static int helperTabulation(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int incl = dp[i - 2] + nums[i];
            int excl = dp[i - 1];
            dp[i] = Math.max(incl, excl);
        }

        return dp[nums.length - 1];
    }


    // Space Optimization
    // TC - O(n), SC - O(1)
    private static int helperSpaceOptimize(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int incl = prev2 + nums[i];
            int excl = prev1;

            int ans = Math.max(incl, excl);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }


    public static void main(String[] args) {
        int[] nums = {9, 9, 8, 2};
        System.out.println(maximumSumOfNonAdjacentElements(nums));
    }

}
