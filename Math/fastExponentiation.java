package Math;

public class fastExponentiation {

    // Time Complexity = O(log n)
    static int modularExponentiation(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 != 0)
                ans *= x;
            x *= x;
            n >>= 1;  // n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println(modularExponentiation(x, n));
    }

}
