package Sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else
                    break;
            }
        }
    }

    static void insertionSortWithWhile(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
