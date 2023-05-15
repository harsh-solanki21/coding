package BitManipulation;

public class PowerOf2 {

    // You are given a number. Find out if it's power of 2 or not.
    // There should be only one set bit in the binary representation of the number. Only then the number is power of 2.

    public static void main(String[] args) {
        int n = 32;
        System.out.println(power(n));
    }

    static boolean power(int n) {
        if(n == 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }

}
