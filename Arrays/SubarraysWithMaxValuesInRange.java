package Arrays;

public class SubarraysWithMaxValuesInRange {

//    Given an array of N elements and L and R.
//    print the number of sub-arrays such that the value of the maximum array element in that subarray is
//    at least L and at most R.

    static long countSubarrays(int[] nums, int L, int R) {
        long count = 0, pre = 0, preLow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < L) {
                count += pre;
                preLow++;
            } else if (nums[i] > R) {
                pre = preLow = 0;
            } else {
                count += (pre + preLow + 1);
                pre += preLow + 1;
                preLow = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 11, 3, 0};
        int L = 1, R = 10;
        System.out.println(countSubarrays(nums, L, R));
    }

}
