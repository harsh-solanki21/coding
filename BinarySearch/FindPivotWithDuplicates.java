package BinarySearch;

public class FindPivotWithDuplicates {

    static int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // skip the duplicates
                // NOTE: What if these elements at start and end were the pivots?
                // Check if start is pivot
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // Check whether end is pivot
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // Left side is sorted , so pivot should be in right
            else if (nums[start] < nums[mid] || nums[start] == nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 2, 3, 3};
        System.out.println(findPivot(nums));
    }

}
