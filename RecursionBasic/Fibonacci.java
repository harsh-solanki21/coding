package RecursionBasic;

public class Fibonacci {

    // TC - O(2^n)
    static int fibonacciRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // TC - O(n)   SC - O(n)
    static int fibonacciNN(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];
    }

    // TC - O(n)   SC - O(1)
    static int fibonacciN(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // TC - O(log(n))   SC - O(1)
    static int[] f = new int[100];

    static int fibonacciLogn(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return (f[n] = 1);
        }

        // If fib(n) is already computed
        if (f[n] != 0) {
            return f[n];
        }

        int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

        // Applying above formula
        // Note: value n&1 is 1 if n is odd, else 0
        f[n] = (n & 1) == 1 ? (fibonacciLogn(k) * fibonacciLogn(k) + fibonacciLogn(k - 1) * fibonacciLogn(k - 1))
                : (2 * fibonacciLogn(k - 1) + fibonacciLogn(k)) * fibonacciLogn(k);

        return f[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(fibonacciRecursion(n));
        System.out.println(fibonacciNN(n));
        System.out.println(fibonacciN(n));
        System.out.println(fibonacciLogn(n));
    }

}
