package Sorting;

import java.util.Arrays;

public class HeapSort {

    static void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            heapify(nums, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 5, 6, 7};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
