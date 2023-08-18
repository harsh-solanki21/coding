package BinarySearch;

public class OrderAgnosticBS {

    static int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
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
//        int[] nums = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] nums = {89, 45, 22, 18, 16, 15, 4, 3, 2, 0, -4, -12, -18};
        int target = 22;
        int ans = orderAgnosticBinarySearch(nums, target);
        System.out.println(ans);
    }

}
