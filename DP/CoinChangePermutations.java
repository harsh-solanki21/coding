package DP;

public class CoinChangePermutations {
    static int coinChange(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int amount = 10;
        System.out.println(coinChange(coins, amount));
    }

}
