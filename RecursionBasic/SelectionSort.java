package RecursionBasic;

import java.util.Arrays;

public class SelectionSort {

    // When you need to paas any variable in the future function call then pass it in the argument
    static void selectionSort(int[] nums, int i, int j, int max) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (nums[j] > nums[max]) {
                selectionSort(nums, i, j + 1, j);
            } else {
                selectionSort(nums, i, j + 1, max);
            }
        } else {
            int temp = nums[max];
            nums[max] = nums[i - 1];
            nums[i - 1] = temp;
            selectionSort(nums, i - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 5, 7, 4, 8, 2, 3};
        selectionSort(nums, nums.length, 0, 0);
        System.out.println(Arrays.toString(nums));
    }

}
