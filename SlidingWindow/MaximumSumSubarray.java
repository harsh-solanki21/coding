package SlidingWindow;

public class MaximumSumSubarray {

    // Identify the question of Sliding Window
    // 1.The question will be of an Array or String
    // 2. Subarray or Substring will be asked
    // 3. Maximum or Minimum will be asked
    // 4. Window size will be given

    // Maximum Sum Subarray of size K

    public static int maxSum(int[] arr, int n, int k) {
        if(n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int res = 0;
        for(int i=0; i<k; i++) {
            res += arr[i];
        }

        int currentSum = res;
        for (int i=k; i<n; i++) {
            currentSum += arr[i] - arr[i-k];
            res = Math.max(res, currentSum);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

}
