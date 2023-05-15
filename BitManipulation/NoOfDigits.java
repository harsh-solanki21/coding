package BitManipulation;

public class NoOfDigits {

    // Brute force approach for this program is
    //    while(n > 0) {
    //        count++;
    //    }

    public static void main(String[] args) {
        int n = 34567;
        int base = 2;
        int ans = (int)(Math.log(n) / Math.log(base)) + 1;
        // If you want to convert anything to base then you just divide by the same log of that with base.
        System.out.println(ans);
        // Time complexity = logn
    }

}
