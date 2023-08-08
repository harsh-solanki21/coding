package Sorting;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    static void selectionSortEfficient(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min_index] > nums[j]) {
                    min_index = j;
                }
            }
            // can put if condition for execute below code only if min_index != i
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
