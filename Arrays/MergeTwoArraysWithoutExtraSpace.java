package Arrays;

import java.util.Arrays;

public class MergeTwoArraysWithoutExtraSpace {

    static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            int j, last = nums1[m - 1];
            for (j = m - 2; j >= 0 && nums1[j] > nums2[i];
                 j--)
                nums1[j + 1] = nums1[j];

            if (last > nums2[i]) {
                nums1[j + 1] = nums2[i];
                nums2[i] = last;
            }
        }

        int[] ans = new int[m + n];
        System.arraycopy(nums1, 0, ans, 0, m);
        System.arraycopy(nums2, 0, ans, m, n);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 5, 9, 10, 15, 20};
        int[] nums2 = new int[]{2, 3, 8, 13};
        int[] ans = merge(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

}
