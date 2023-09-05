package Arrays;

import java.util.Arrays;

public class MoveZerosAtFrontAndEnd {

    static int[] zerosAtFront(int[] nums) {
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (index != i) {
                    nums[i] = 0;
                }
                index--;
            }
        }
        return nums;
    }

    static int[] zerosAtEnd(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (index != i) {
                    nums[i] = 0;
                }
                index++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(zerosAtFront(nums)));
        System.out.println(Arrays.toString(zerosAtEnd(nums)));
    }

}
