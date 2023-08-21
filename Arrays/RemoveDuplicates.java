package Arrays;

public class RemoveDuplicates {

//    static int removeDuplicates(int[] nums) {
//        if (nums.length == 1)
//            return 1;
//        int i = 1, count = 1;
//        while (i < nums.length) {
//            if (nums[i - 1] != nums[i]) {
//                nums[count++] = nums[i];
//            }
//            i++;
//        }
//        return count;
//    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        int i = 0, j = 1;
        int count = 1, index = 0;
        nums[index++] = nums[0];
        while (j <= nums.length - 1) {
            if (nums[i] == nums[j])
                j++;
            else {
                count++;
                i = j;
                nums[index++] = nums[j];
                j++;
            }
        }
        for (int k=0; k<count; k++) {
            System.out.print(k + " ");
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\n" + removeDuplicates(nums));
    }

}
