package RecursionBasic;

public class Power {

    // TC - O(log n)
    // Recursive
    static int power1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = power1(x, n / 2);
        int ans = res * res;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
    }

    // Iterative
    static int power2(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                x = x * x;
                n /= 2;
            } else {
                ans *= x;
                n--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(power1(2, 8));
        System.out.println(power2(2, 8));
    }

}
