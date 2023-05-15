package binarySearch;

public class CeilingAndFloorOfNumber {

    // Ceiling of a given number means, in the array, find the smallest number that is >= the target number
    // Just return end instead of start in the below function. that will give us floor number AKA find the biggest number
    // that is <= the target number

    static int ceilNumber(int[] a, int target) {

        // when the target element is greater than the greatest number on the array
        if(target > a[a.length-1]) {
            return -1;
        }

        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(a[mid] == target)
                return target;
            else if(a[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {

        int[] a = {2,3,5,9,14,16,18};
        int target = 1;

        System.out.println(ceilNumber(a, target));

    }

}
