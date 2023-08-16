package RecursionBasic;

public class Steps {

    // Question : Number of Steps to Reduce a Number to Zero
    // Given an integer num, return the number of steps to reduce it to zero.
    // In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

    static int numberOfSteps(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + numberOfSteps(n / 2);
        }
        return 1 + numberOfSteps(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

}
