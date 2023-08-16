package RecursionBasic;

public class SumOfDigits {

    // Time complexity is number of digits = O(log n)
    // (int)Math.floor(Math.log10(no_of_digits) + 1);   <=  Time Complexity

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sum(n / 10);
    }

    // productOfDigits
    static int product(int n) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * product(n / 10);
    }

    public static void main(String[] args) {
        int n = 1342;
        System.out.println(sum(n));
    }

}
