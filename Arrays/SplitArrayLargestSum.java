package Arrays;

import java.util.Arrays;

public class SplitArrayLargestSum {

    // Google
//    Given an array arr[] of N elements and a number K.,
//    split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible.
//    Find that possible subarray sum.

    static int splitArray(int[] nums, int k) {
        long low = Arrays.stream(nums).max().getAsInt();
        long high = Arrays.stream(nums).sum();

        while (low < high) {
            long mid = low + (high - low) / 2;
            int count = getCount(nums, mid);

            if (count > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) low;
    }

    private static int getCount(int[] nums, long maxSum) {
        int count = 1;
        long currentSum = 0;

        for (int i : nums) {
            currentSum += i;
            if (currentSum > maxSum) {
                count++;
                currentSum = i;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        System.out.println(splitArray(nums, k));
    }

}
