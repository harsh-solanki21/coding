package BitManipulation;

public class NoOfDigits {

    // Time complexity = log(n)
    public static void main(String[] args) {
        int n = 34567;
        int base = 2; // Enter base here to get answer for that base (e.g. 10 => ans: 5)
        int ans = (int) (Math.log(n) / Math.log(base)) + 1;
        System.out.println(ans);
    }

}
