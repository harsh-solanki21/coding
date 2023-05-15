package DP;

public class CoinChangeCombination {

    // https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13

    static int coinChange(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j < dp.length; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5};
        int amount = 7;
        System.out.println(coinChange(coins, amount));
    }

}
