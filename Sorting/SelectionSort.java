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

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
