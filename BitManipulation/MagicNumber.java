package BitManipulation;

public class MagicNumber {

    // Amazon Question
    // Magic number means:

    //         5^4  5^3  5^2  5^1      Magic Number
    //    1 =        0    0    1   ->       5
    //    2 =        0    1    0   ->       25
    //    3 =        0    1    1   ->       30  (5^2 + 5^1)
    //    4 =        1    0    0   ->       125
    //    8 =   1    0    0    0   ->       625

    public static void main(String[] args) {
        int n = 8;
        int ans = 0;
        int base = 5;
        while(n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base  = base * 5;
        }
        System.out.println(ans);
    }

    // Time complexity = length of no. of bits of n
    // Formula to find no. of digits of binary representation of a number
    // (int) (logb n)+1
    // This program is written already. see NoOfDigits program.

}
