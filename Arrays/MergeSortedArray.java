package Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n - 1;
        int i = m - 1, j = n - 1;

        while (size >= 0) {
            if (j >= 0 && i >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[size--] = nums1[i--];
                } else {
                    nums1[size--] = nums2[j--];
                }
            } else if (i >= 0) {
                nums1[size--] = nums1[i--];
            } else {
                nums1[size--] = nums2[j--];
            }
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] ans = merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(ans));
    }

}
