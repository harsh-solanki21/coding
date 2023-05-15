package binarySearch;

public class PeakIndexMountainArray {

    // Find peak index in mountain array
    // It is also known as Bitonic array

    static int peakIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid+1]) {
                // we are in the descending part of the array
                // this might be the answer but look left
                // this is why end != mid - 1
                end = mid;
            }
            else {
                // we are in the ascending part of the array
                start = mid + 1;  // because we know that mid+1 element > mid element
            }
        }
        // In the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end always trying to find max element in the above 2 checks
        // Hence, when they are pointing to just one element, that is the max one because that is what checks say
        // more elaboration: at every point of time for start and end, they have the best possible ans till that time
        // and if we are saying that only one item is remaining, hence because of above line that is the best possible ans
        return start;  // or return end as both are equal
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,0}; //{1,2,3,4,5,6,5,4,2};
        System.out.println(peakIndex(nums));

    }

}
