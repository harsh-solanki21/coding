package DP;

public class Fibonacci {

    // DP - Memoization
    static int fiboRecursive(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int fibo1 = fiboRecursive(n - 1, dp);
        int fibo2 = fiboRecursive(n - 2, dp);
        int fibo = fibo1 + fibo2;

        dp[n] = fibo;
        return fibo;
    }


    static int fiboIterative(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fiboRecursive(n, new int[n + 1]));
        System.out.println(fiboIterative(n));
    }

}
