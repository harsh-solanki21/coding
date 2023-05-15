package Sorting;

import java.util.Arrays;

public class MergeSortInPlace {

    // Quick Sort is preferred for Arrays because:

    // 1. Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage)
    // whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive.
    // Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm.
    // 2. Comparing average complexity we find that both type of sorts have O(NlogN) average complexity but the constants differ.
    // For arrays, merge sort loses due to the use of extra O(N) storage space.


    // At every level, N elements are being merged
    static void mergeInPlace(int[] nums, int start, int mid, int end) {
        int[] mix = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (nums[i] < nums[j]) {
                mix[k] = nums[i];
                i++;
            } else {
                mix[k] = nums[j];
                j++;
            }
            k++;
        }

        // when one of the array is finished and other is not
        while (i < mid) {
            mix[k] = nums[i];
            i++;
            k++;
        }
        while (j < end) {
            mix[k] = nums[i];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            nums[start + l] = mix[l];
        }

    }

    static void mergeSortInPlace(int[] nums, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortInPlace(nums, start, mid);
        mergeSortInPlace(nums, mid, end);
        mergeInPlace(nums, start, mid, end);
    }


    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        mergeSortInPlace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

}
