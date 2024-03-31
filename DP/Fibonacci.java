package DP;

public class Fibonacci {

    // Memoization
    static int fiboMemoize(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fiboMemoize(n - 1, dp) + fiboMemoize(n - 2, dp);
        return dp[n];
    }


    // Tabulation
    static int fiboTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    // Space Optimization
    static int fiboSpaceOptimize(int n) {
        int prev2 = 0, prev = 1;
        if (n == 0) {
            return prev2;
        }

        for (int i = 2; i <= n; i++) {
            int temp = prev2 + prev;
            prev2 = prev;
            prev = temp;
        }

        return prev;
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(fiboMemoize(n, new int[n + 1]));
        System.out.println(fiboTabulation(n));
        System.out.println(fiboSpaceOptimize(n));
    }

}
