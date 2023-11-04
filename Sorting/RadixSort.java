package Sorting;

import java.util.Arrays;

public class RadixSort {

    // Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping the keys by the individual digits which share the same significant position and value.
    // In practical implementations, radix sort is often faster than other comparison-based sorting algorithms, such as quicksort or merge sort, for large datasets, especially when the keys have many digits.

    // TC - O(d * (n + b))
    // where d is the number of digits, n is the number of elements, and b is the base of the number system being used

    // Sc - O(n + b)
    // where n is the number of elements and b is the base of the number system

    // Steps to sort array using Radix Sort:
    // 1. Find the largest element in the array, which is 802. It has three digits, so we will iterate three times, once for each significant place.
    // 2. Sort the elements based on the ones place digits.
    // 3. Sort the elements based on the tens place digits.
    // 4. Sort the elements based on the hundreds place digits.


    static void radixSort(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, exp);
        }

    }

    private static void countSort(int[] nums, int exp) {
        int[] output = new int[nums.length];
        int[] count = new int[10];

        for (int i : nums) {
            count[(i / exp) % 10]++;
        }

//        System.out.println("\nCount array for " + exp + "'s place : " + Arrays.toString(count));

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

//        System.out.println("Updated count array: " + Arrays.toString(count));

        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

//        System.out.println("Output array: " + Arrays.toString(output));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
