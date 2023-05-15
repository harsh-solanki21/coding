package binarySearch;

public class RotatedSortedArray {

    // find target in rotated sorted array

    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if(nums.length== 1 && nums[0] != target) {
            return -1;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[start] <= nums[mid]) {
                //check -> is target lies in first part of sorted array?
                if(target >= nums[start] && target <= nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                //check -> is target lies in second part of sorted array?
                if (target >= nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};  //{5,1,3};
        int target = 0;
        System.out.println(search(nums, target));
    }

}
