package Arrays;

public class LargestSumSubarrayOfSizeAtLeastK {

//    Given an array a of length n and a number k,
//    find the largest sum of the subarray containing at least k numbers.
//    It is guaranteed that the size of array is at-least k.

    static long maxSumWithK(long[] nums, long k) {
        long maxi = Long.MIN_VALUE, sum = 0, prevSum = 0;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxi = Math.max(maxi, sum);
        for (int i = (int) k; i < nums.length; i++) {
            sum += nums[i];
            prevSum += nums[idx++];
            maxi = Math.max(maxi, sum);

            if (prevSum < 0) {
                sum -= prevSum;
                maxi = Math.max(maxi, sum);
                prevSum = 0;
            }
        }

        return maxi;
    }


    public static void main(String[] args) {
        long[] nums = {-4, -2, 1, -3};
        long k = 2;
        System.out.println(maxSumWithK(nums, k));
    }

}
