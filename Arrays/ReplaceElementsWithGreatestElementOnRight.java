package Arrays;

public class ReplaceElementsWithGreatestElementOnRight {

    static int[] replaceElements(int[] nums) {
        int i = nums.length - 1;
        int init = -1;
        while (i >= 0) {
            int temp = nums[i];
            nums[i--] = init;
            init = Math.max(init, temp);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {17, 18, 5, 4, 6, 1};
        int[] ans = replaceElements(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
