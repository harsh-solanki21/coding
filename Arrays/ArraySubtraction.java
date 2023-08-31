package Arrays;

import java.util.Arrays;

public class ArraySubtraction {

    static int[] subtraction(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.max(nums1.length, nums2.length)];
        int i = nums1.length - 1, j = nums2.length - 1, k = ans.length - 1, carry = 0;

        while (k >= 0) {
            int diff = 0;
            int val = j >= 0 ? nums2[j] : 0;
            if (nums1[i] + carry >= val) {
                diff = nums1[i] + carry - val;
                carry = 0;
            } else {
                diff = nums1[i] + carry + 10 - val;
                carry = -1;
            }

            ans[k] = diff;

            i--;
            j--;
            k--;
        }

        int leadingZeros = 0;
        for (int a = 0; a < ans.length; a++) {
            if (ans[a] == 0) {
                leadingZeros++;
            } else {
                break;
            }
        }
        if (leadingZeros > 0) {
            int[] res = new int[ans.length - leadingZeros];
            for (int a = 0; a < res.length; a++) {
                res[a] = ans[a + leadingZeros];
            }
            return res;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 5};
        int[] nums2 = {9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(subtraction(nums1, nums2)));
    }

}
