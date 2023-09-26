package DP;

public class DiceRollsWithTargetSum {

    // https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

    static int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        return getCount(n, k, target, dp);
    }

    private static int getCount(int dice, int faces, int target, Integer[][] dp) {
        if (target < 0 || dice < 0) {
            return 0;
        }
        if (dice == 0 && target == 0) {
            return 1;
        }
        if (dp[dice][target] != null) {
            return dp[dice][target];
        }

        int ans = 0;
        for (int i = 1; i <= faces; i++) {
            ans = (ans + getCount(dice - 1, faces, target - i, dp)) % 1000000007;
        }

        dp[dice][target] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(numRollsToTarget(n, k, target));
    }

}
