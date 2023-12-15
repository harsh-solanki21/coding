package Arrays;

public class CountBinaryStrings {

//    Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.
//    Output your answer modulo 109 + 7.
//    Example: n = 3
//    Output = 5 (000, 001, 010, 100, 101)

    static long countStrings(int n) {
        int zero = 1, sum = 2;
        for (int i = 2; i <= n; i++) {
            int temp = sum;
            sum += zero;
            zero = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countStrings(n));
    }

}
