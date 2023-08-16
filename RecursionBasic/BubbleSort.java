package RecursionBasic;

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] nums, int i, int j) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
            bubbleSort(nums, i, j + 1);
        } else {
            bubbleSort(nums, i - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 5, 7, 4, 8, 2, 3};
        bubbleSort(nums, nums.length - 1, 0);
        System.out.println(Arrays.toString(nums));
    }

}
