import java.util.*;

public class Main {

    // Time Complexity: O(N^2)
    // Auxiliary Space: O(N)
//    static int countSum(int[] nums, int sum) {
//        int count = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int temp = nums[i] + nums[j];
//                if (temp < sum && map.containsKey(sum - temp)) {
//                    count += map.get(sum - temp);
//                }
//            }
//            for (int j = 0; j < i; j++) {
//                int temp = nums[i] + nums[j];
//                if (temp < sum) {
//                    if (map.containsKey(temp))
//                        map.put(temp, map.get(temp) + 1);
//                    else
//                        map.put(temp, 1);
//                }
//            }
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {4, 5, 3, 1, 2, 4};
//        int sum = 13;
//        System.out.print(countSum(nums, sum));
//    }


//    static int maxProduct(int[] nums) {
//        if (nums.length < 3)
//            return -1;
//
//        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
//        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
//
//        for (int i : nums) {
//            if (i > maxA) {
//                maxC = maxB;
//                maxB = maxA;
//                maxA = i;
//            } else if (i > maxB) {
//                maxC = maxB;
//                maxB = i;
//            } else if (i > maxC) {
//                maxC = i;
//            }
//            if (i < minA) {
//                minB = minA;
//                minA = i;
//            } else if (i < minB) {
//                minB = i;
//            }
//        }
//
//        return Math.max(minA * minB * maxA, maxA * maxB * maxC);
//    }

//    public static void main(String[] args) {
//        int[] nums = {-16, -1, 1, 2, 3, 8, 9};
//        System.out.println(maxProduct(nums));
//    }


//    static class MinHeapComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer number1, Integer number2) {
//            int value = number1.compareTo(number2);
//            if (value > 0) {
//                return -1;
//            } else if (value < 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }
//
//    // TC - O(n logk)
//    static int kthSmallest(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new MinHeapComparator());
//        for (int i = 0; i < nums.length; ++i) {
//            heap.add(nums[i]);
//            if (heap.size() > k) {
//                heap.remove();
//            }
//        }
//        return heap.peek();
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {7, 10, 4, 3, 20, 15};
//        int k = 4;
//        System.out.println(kthSmallest(nums, k));
//    }

    int findPeakInMountainArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start; // or return end as both are equal
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 4, 3, 2};

        Main obj = new Main();
        int ans = obj.findPeakInMountainArray(nums);
        System.out.println(ans);
    }

}