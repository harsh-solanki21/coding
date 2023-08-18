package BinarySearch;

public class Sqrt {

    static int sqrt(int x) {
        if (x < 2) {
            return x;
        }

        long start = 1, end = x / 2;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long check = mid * mid;
            if (check == x) {
                return (int) mid;
            }
            if (check < x) {
                start = mid + 1;
                ans = mid;
            } else
                end = mid - 1;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int x = 11;
        System.out.println(sqrt(x));
    }

}
