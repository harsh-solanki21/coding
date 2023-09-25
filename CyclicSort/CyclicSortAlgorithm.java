package CyclicSort;

import java.util.Arrays;

public class CyclicSortAlgorithm {

    // When the array is given from 1 to n use CYCLIC(CYCLE) SORT
    // The values in the array should cover all the values from 1 to n
    // All the values from 1 to n should be present in the array
    // In rhe worst case, 2n-1 swaps will be made.
    // Time complexity = O(n)

    // If range is [0..N] then every element will be at index = value
    // If range is [1..N] then every element will be at index = value-1

    // This type of question means Cyclic Sort
    // Given an integer array nums of length n where all the integers of nums are in the range [1, n]
    // You must write an algorithm that runs in O(n) time and uses only constant extra space.

    static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        sort(nums);
        System.out.println(Arrays.toString((nums)));
    }

}
