package Arrays;

public class ValidMountainArray {

    static boolean mountainArray(int[] nums) {
        if (nums.length < 3)
            return false;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < nums.length - 1 && nums[start] < nums[start + 1])
            start++;
        while (end - 1 > 0 && nums[end] < nums[end - 1])
            end--;
        return start == end;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 1};
        System.out.println(mountainArray(nums));
    }

}
