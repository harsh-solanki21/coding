package RecursionBasic;

public class CountZeros {

    // Approach 1
    static int count(int n) {
        return helper(n, 0);
    }

    // special pattern, how to pass a value to above calls
    static int helper(int n, int c) {
        if (n == 0) {
            return c;
        }
        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, c + 1);
        }
        return helper(n / 10, c);
    }


    // Approach 2
    static int count2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 0) {
            return 1 + count2(n / 10);
        } else {
            return count2(n / 10);
        }
    }

    // Simplified Approach 2
    static int count3(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 == 0 ? 1 + count(n / 10) : count(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(count(300210));
        System.out.println(count2(300210));
        System.out.println(count3(300210));
    }

}
