package Sorting;

import java.util.Arrays;

public class QuickSort {

    static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return (i + 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pi = partition(nums, start, end);
            quickSort(nums, start, pi - 1);
            quickSort(nums, pi + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 8, 9, 1, 5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
