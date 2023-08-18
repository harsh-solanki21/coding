package BinarySearch;

public class PeakIndexMountainArray {

    // Find peak index in mountain array
    // It is also known as Bitonic array

    static int peakIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // we are in the descending part of the array
                // this might be the answer but look left
                // this is why end != mid - 1
                end = mid;
            } else {
                // we are in the ascending part of the array
                start = mid + 1;  // because we know that mid+1 element > mid element
            }
        }

        return start;  // or return end as both are equal
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 5, 4, 2};
        System.out.println(peakIndex(nums));
    }

}
