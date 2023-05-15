package Arrays;

public class KadensAlgorithm {

    static int largestSumContiguousSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                start = s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }

        System.out.println("Starting index: " + start);
        System.out.println("Ending index: " + end);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        System.out.println("Maximum contiguous sum: " + largestSumContiguousSubarray(nums));
    }

}
