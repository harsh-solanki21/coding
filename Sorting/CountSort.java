package Sorting;

import java.util.Arrays;

public class CountSort {

    // TC - O(N + M), SC - O(N + M)
    // where N is size of inputArray, M is the size of countArray

    // Advantages:
    // Counting sort generally performs faster than all comparison-based sorting algorithms, such as merge sort and quicksort, if the range of input is smaller.
    // It is a stable algorithm.

    // Disadvantages:
    // Counting sort doesn't work on decimal values.
    // It is inefficient if the range of values to be sorted is very large.
    // It is not an In-place sorting algorithm, It uses extra space for sorting the array elements.

    static void countSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int[] countArray = new int[max + 1];
        for (int i : nums) {
            countArray[i]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                nums[index++] = i;
                countArray[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {6, 3, 10, 9, 2, 4, 9, 7};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
