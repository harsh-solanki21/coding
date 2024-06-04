package DP;

import java.util.Arrays;

public class JumpGame {

    // https://leetcode.com/problems/jump-game/description/

    // Recursive Approach (Exponential Time Complexity)
    // TC - O(2^n), SC - O(n)
    static boolean canJumpRecursion(int[] nums) {
        return canJumpFromPosition(nums, 0);
    }

    private static boolean canJumpFromPosition(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= furthestJump; i++) {
            if (canJumpFromPosition(nums, i)) {
                return true;
            }
        }

        return false;
    }


    // Memoization
    // TC - O(n^2), SC - O(n)
    static boolean canJumpMemoize(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jumpFrom(nums, dp, 0);
    }

    private static boolean jumpFrom(int[] nums, int[] dp, int index) {
        if (index >= nums.length - 1) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] != 0;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (jumpFrom(nums, dp, index + i)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }


    // Tabulation
    // TC - O(n^2), SC - O(n)
    static boolean canJumpTabulation(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }


    // Greedy Approach
    // TC - O(n)
    static boolean canJumpGreedy(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJumpRecursion(nums));
        System.out.println(canJumpMemoize(nums));
        System.out.println(canJumpTabulation(nums));
        System.out.println(canJumpGreedy(nums));
    }

}
