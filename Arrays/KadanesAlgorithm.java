package Arrays;

public class KadanesAlgorithm {

    static int largestSumContiguousSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        System.out.println(largestSumContiguousSubarray(nums));
    }

}
