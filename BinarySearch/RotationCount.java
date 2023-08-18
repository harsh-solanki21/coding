package BinarySearch;

public class RotationCount {

    // Find the rotation count in Rotated Sorted array

    // use this for non-duplicates
    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases are here
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // use this when array contains duplicates
    static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases are here
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // If the element at middle, start and end are equal then just skip the duplicate
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot?
                // check if start is pivot
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;

            }
            // left side is sorted, so pivot should be in right
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static int countRotations(int[] nums) {
        int pivot = findPivotWithDuplicates(nums);
        return pivot + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 6, 6, 6, 6, 1};
        System.out.println(countRotations(nums));
    }

}
