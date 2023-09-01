package Arrays;

import java.util.Arrays;

public class RotateArray {

    // Solution 1
    static void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length - k;
        reverse(nums, 0, n - 1);
        reverse(nums, n, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Addition in Solution 1
    // when input of k = -2 => 3, 4, 5, 6, 7, 1, 2
    // when input of k = 0  => 1, 2, 3, 4, 5, 6, 7
    // when input of k = 2  => 6, 7, 1, 2, 3, 4, 5
    static int[] rotateArray(int[] nums, int k) {
        k %= nums.length;
        if (k < 0) {
            k += nums.length;
        }

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        return nums;
    }

    // Solution 2
    static int[] rotate2(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = -2;
        System.out.println(Arrays.toString(rotateArray(nums, k)));
    }

}
