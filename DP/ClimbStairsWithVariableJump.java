package DP;

public class ClimbStairsWithVariableJump {

    // https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3

    // Recursive Solution with print path
    static void climbStairsVariableJumps(int[] nums, int i, String ans) {
        if (i == nums.length) {
            System.out.println(ans);
            return;
        }
        if (i > nums.length) {
            return;
        }

        for (int j = 1; j <= nums[i]; j++) {
            climbStairsVariableJumps(nums, i + j, ans + j);
        }

    }


    // Tabulation
    static int variablePath(int[] nums, int[] dp) {
        dp[nums.length] = 1;  // steps to go 6 to 6 is 1 (that step is don't move)
                              // but moves to go 6 to 6 is 0 (because we don't need to move to go 6 from 6)
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 0, 2, 3};
//        climbStairsVariableJumps(nums, 0, "");
        System.out.println(variablePath(nums, new int[nums.length + 1]));
    }

}
