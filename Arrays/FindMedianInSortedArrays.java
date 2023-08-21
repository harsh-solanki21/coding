package Arrays;

public class FindMedianInSortedArrays {

    static double findMedian(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i = nums1.length - 1, j = nums2.length - 1;
        int len = nums1.length + nums2.length - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                ans[len--] = (nums1[i] <= nums2[j]) ? nums2[j--] : nums1[i--];
            } else if (i >= 0) {
                ans[len--] = nums1[i--];
            } else {
                ans[len--] = nums2[j--];
            }
        }

        if (ans.length % 2 == 0) {
            return (double) (ans[ans.length / 2 - 1] + ans[ans.length / 2]) / 2;
        } else {
            return ans[ans.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedian(nums1, nums2));
    }

}
