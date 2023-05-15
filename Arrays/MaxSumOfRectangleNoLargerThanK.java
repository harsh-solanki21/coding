package Arrays;

public class MaxSumOfRectangleNoLargerThanK {

    static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] nums = new int[m];
            for (int j = i; j < n; j++) {
                for (int x = 0; x < m; x++) {
                    nums[x] += matrix[j][x];
                }
                ans = Math.max(ans, findFromArray(nums, m, k));
                if (ans == k) {
                    return ans;
                }
            }
        }

        return ans;
    }

    private static int findFromArray(int[] arr, int n, int k) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum <= k) {
                    ans = Math.max(ans, sum);
                }
                if (sum == k) {
                    return ans;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
    }

}
