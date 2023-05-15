package Arrays;

public class ReorderedPowerOf2 {

    // https://leetcode.com/problems/reordered-power-of-2/
    static boolean reorderedPowerOf2(int n) {
        int[] Count = count(n);
        int power = 1;
        for (int i = 0; i < 31; i++) {
            int[] PowerCount = count(power);
            if (equal(Count, PowerCount)) {
                return true;
            }
            power *= 2;
        }
        return false;
    }

    private static int[] count(int n) {
        int[] count = new int[10];
        while (n != 0) {
            count[n % 10]++;
            n /= 10;
        }
        return count;
    }

    private static boolean equal(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10));
    }

}
