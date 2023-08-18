package BinarySearch;

public class FindInMountainArray {

    // logic of this question and RotatedSortedArray is seems to be the same
    // But RotatedSortedArray program is better because this program is not giving right ans in one of the test cases

    static int search(int[] nums, int target) {
        int peak = peakIndex(nums);
        int firstTry = orderAgnosticBinarySearch(nums, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBinarySearch(nums, target, peak + 1, nums.length - 1);
    }

    static int peakIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end) {
        boolean isAsc = nums[start] < nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

}
