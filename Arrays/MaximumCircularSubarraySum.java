package Arrays;

public class MaximumCircularSubarraySum {

    // Kadane's Algorithm
    static int maxSubarraySum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int currMax = nums[0], maxSoFar = nums[0], currMin = nums[0], minSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSoFar = Math.min(minSoFar, currMin);
        }
        if (minSoFar == sum) {
            return maxSoFar;
        }

        return Math.max(maxSoFar, sum - minSoFar);
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 4, -6, 7, 5, -4};
        int[] nums = {4, -4, 6, -6, 10, -11, 12};
        System.out.println(maxSubarraySum(nums));
    }

}
