package math;

public class PrimeInRange {

    // Sieve of Eratosthenes
    // Time Complexity: O(n * log(log n))
    // Auxiliary Space: O(n)

    public static void main(String[] args) {
        int n = 50;
        boolean[] primes = new boolean[n + 1];
        primeSieve(primes, n);
    }

    static void primeSieve(boolean[] primes, int n) {

        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

}
