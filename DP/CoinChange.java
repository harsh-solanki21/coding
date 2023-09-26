package DP;

import java.util.Arrays;

public class CoinChange {

    // https://leetcode.com/problems/coin-change/

    // Recursive
    // TC - O(coins.length^n), SC - O(n)
    static int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinChangeRecursive(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }

        return min;
    }


    // Memoize
    // TC - O(coins.length * amount), SC - O(n) + O(n)
    static int coinChangeMemoize(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinChangeRecursive(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }

        dp[amount] = min;
        return min;
    }


    // Tabulation
    // TC - O(amount * coins.length), SC - O(n)
    static int coinChangeTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
//        int ans = coinChangeRecursive(coins, amount);
//        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

//        int ans = coinChangeMemoize(coins, amount, new int[amount + 1]);
//        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

        System.out.println(coinChangeTabulation(coins, amount));
    }

}
