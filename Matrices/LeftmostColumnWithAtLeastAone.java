package Matrices;

public class LeftmostColumnWithAtLeastAone {

//    This problem is an interactive problem.
//
//    A binary matrix means that all elements are 0 or 1.
//    For each individual row of the matrix, this row is sorted in non-decreasing order.
//
//    Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
//    If such index doesn't exist, return -1.
//
//    You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
//    BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
//    BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
//
//    Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
//    Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//    For custom testing purposes you're given the binary matrix mat as input in the following four examples.
//    You will not have access the binary matrix directly.
//    Ex.1 - mat = [[0,0],[1,1]]  => Output - 0
//    Ex.2 - mat = [[0,0],[0,1]]  => Output - 1
//    Ex.3 - mat = [[0,0],[0,0]]  => Output - -1
//    Ex.4 - mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]  => Output - 1
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 100
//    mat[i][j] is either 0 or 1.
//    mat[i] is sorted in a non-decreasing way.


    // Approach 1 - Binary Search
    // TC - O(n * log m), SC - O(1),   n - no. of rows, m - no. of columns

    static int max = 101;

    static int leftMostColumnWithOne(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        int min = max;

        for (int i = 0; i < rows; i++) {
            min = Math.min(min, binarySearch(nums, i, cols));
        }
        return min == max ? -1 : min;
    }

    private static int binarySearch(int[][] nums, int row, int n) {
        if (nums[row][n - 1] == 0)
            return max;
        if (nums[row][0] == 1)
            return 0;

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[row][mid] == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


    // Approach 2 - Linear Time
    // TC - O(n + m), SC - O(1),   n - no. of rows, m - no. of columns

    static int leftMostColumnWithOneLinear(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int ans = -1;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (nums[row][col] == 1) {
                ans = col;
                col--;
            } else {
                row++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        System.out.println(leftMostColumnWithOne(nums));
        System.out.println(leftMostColumnWithOneLinear(nums));
    }


}
