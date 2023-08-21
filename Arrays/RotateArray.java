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

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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
        int k = 3;
        System.out.println(Arrays.toString(rotate2(nums, k)));
    }

}
