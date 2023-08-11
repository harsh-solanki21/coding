import java.util.*;

public class Main {

    // https://leetcode.com/problems/product-of-array-except-self/description/

<<<<<<< HEAD

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
=======
    static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for (int j = nums.length - 2; j > -1; j--) {
            prod *= nums[j + 1];
            ans[j] *= prod;
        }
        return ans;
    }

    static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    static int[] productExceptSelf4(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf3(nums)));
>>>>>>> 96ca978028174472b65724066921b41ca158530e
    }

}