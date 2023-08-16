package Sorting;

import java.util.Arrays;

public class MergeSortInPlace {

    // Quick Sort is preferred for Arrays because:

    // 1. Quick Sort in its general form is an in-place sort (i.e. it does not require any extra storage)
    // whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive.
    // Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm.
    // 2. Comparing average complexity we find that both type of sorts have O(NlogN) average complexity but the constants differ.
    // For arrays, merge sort loses due to the use of extra O(N) storage space.

    static void merge(int[] nums, int start, int mid, int end) {
        int start2 = mid + 1;
        if (nums[mid] <= nums[start2]) {
            return;
        }

        while (start <= mid && start2 <= end) {
            if (nums[start] <= nums[start2]) {
                start++;
            }
            else {
                int value = nums[start2];
                int index = start2;

                while (index != start) {
                    nums[index] = nums[index - 1];
                    index--;
                }
                nums[start] = value;
                start++;
                mid++;
                start2++;
            }
        }
    }

    static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 5, 6, 7};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
