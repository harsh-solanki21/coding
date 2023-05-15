package Sorting;

import java.util.Arrays;

public class MergeSort {

//    1. Divide the array into two halves until it has only one element in array
//    2. Sort the arrays
//    3. Merge the arrays

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    // At every level, N elements are being merged
    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // when one of the array is finished and other is not
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[i];
            j++;
            k++;
        }

        return mix;
    }

//    Time Complexity
//    Total number of levels are (log n)
//    At each level, there are total (n) comparisons being made
//    So, the time complexity is: (total level * work at every level)
//    O(n log(n))

//    Space Complexity
//    SC is the maximum height of the tree
//    O(n)
}
