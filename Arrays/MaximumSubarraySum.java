package Arrays;

import java.util.Arrays;

public class MaximumSubarraySum {

    // O(n^3)
    static int subArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // Cumulative sum approach - O(n^2)
    static int subArraySum2(int[] nums) {
        int[] currentSum = new int[nums.length + 1];
        currentSum[0] = 0;

        for (int i = 1; i < currentSum.length; i++) {
            currentSum[i] = currentSum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(currentSum));

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < currentSum.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = currentSum[i] - currentSum[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    // Kadane's Algorithm - O(n)
    static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 4, 7, 2};
//        System.out.println(subArraySum(nums));
        System.out.println(subArraySum2(nums));
//        System.out.println(maxSubArraySum(nums));
    }

}
