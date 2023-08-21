package Arrays;

import java.util.Arrays;

public class SubarrayWithGivenSum {

    static int[] subArraySum(int[] nums, int sum) {
        int currentSum = nums[0], start = 0;

        for (int i = 1; i <= nums.length; i++) {
            while (currentSum > sum && start < i - 1) {
                currentSum -= nums[start];
                start++;
            }

            if (currentSum == sum) {
                return new int[]{start, i - 1};
            }

            if (i < nums.length) {
                currentSum = currentSum + nums[i];
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        System.out.println(Arrays.toString(subArraySum(nums, sum)));
    }

}
