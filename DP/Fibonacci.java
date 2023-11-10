package DP;

public class Fibonacci {

    // DP - Memoization
    static int fiboRecursive(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fiboRecursive(n - 1, cache) + fiboRecursive(n - 2, cache);
        return cache[n];
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
