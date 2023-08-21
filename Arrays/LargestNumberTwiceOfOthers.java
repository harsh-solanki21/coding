package Arrays;

public class LargestNumberTwiceOfOthers {

    static int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int maxNum = nums[0], index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != index && nums[i] * 2 > maxNum){
                return -1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        System.out.println(dominantIndex(nums));
    }

}
