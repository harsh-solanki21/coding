package RecursionMedium;

public class MaxNumberOfAs {

    // https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/

    static int findoptimal(int n) {
        if (n <= 6) {
            return n;
        }

        int max = 0;
        for (int i = n - 3; i >= 1; i--) {
            int curr = (n - i - 1) * findoptimal(i);
            if (curr > max) {
                max = curr;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Maximum Number of A's with keystrokes is " + i + findoptimal(i));
        }
    }

}
