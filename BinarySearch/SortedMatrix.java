package BinarySearch;

import java.util.Arrays;

public class SortedMatrix {

    // Another approach is convert the 2D array into 1D array and then apply binary search on it
    // Heaps and Priority Queues can also be useful to solve this problem

    // This approach will only applicable on strictly sorted matrix like below one
    // Time complexity = O(log n + log m)

    static int[] search(int[][] nums, int target) {
        int rowStart = 0;
        int rowEnd = nums.length - 1;
        int column = nums[0].length - 1;

        while (rowStart < rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (nums[mid][column] == target) {
                return new int[]{mid, column};
            } else if (nums[mid][column] < target) {
                rowStart = mid + 1;
            } else {
                rowEnd = mid;
            }
        }

        return binarySearch(nums, rowStart, 0, column, target);
    }

    static int[] binarySearch(int[][] nums, int row, int colStart, int colEnd, int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (nums[row][mid] == target) {
                return new int[]{row, mid};
            } else if (nums[row][mid] < target) {
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int target = 7;
        System.out.println(Arrays.toString(search(nums, target)));
    }

//    public static void main(String[] args) {
//        int[][] nums = {{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//                {17, 18, 19, 20}};
//        int target = 13;
//        System.out.println(Arrays.toString(search(nums, target)));
//    }
//
//    static int[] search(int[][] matrix, int target) {
//        int row = matrix.length;
//        int column = matrix[0].length; // be cautious, matrix may be empty
//        if(row == 1)
//            return binarySearch(matrix, 0, 0, column-1, target);
//
//        int rowStart = 0;
//        int rowEnd = row -1;
//        int columnMid = column / 2;
//        // run the loop till 2 rows are remaining
//        while(rowStart < (rowEnd-1)) {  // while this is true it will have more than 2 rows
//            int mid = rowStart + (rowEnd - rowStart) / 2;
//            if(matrix[mid][columnMid] == target)
//                return new int[] {mid, columnMid};
//            if(matrix[mid][columnMid] < target)
//                rowStart = mid;
//            else
//                rowEnd = mid;
//        }
//
//        // now we have 2 rows
//        // check whether the target is in the column of 2 rows
//        if(matrix[rowStart][columnMid] == target)
//            return new int[] {rowStart, columnMid};
//
//        if(matrix[rowStart+1][columnMid] == target)
//            return new int[] {rowStart+1, columnMid};
//
//        // search in first half
//        if(target <= matrix[rowStart][columnMid-1])
//            return binarySearch(matrix, rowStart, 0, columnMid-1, target);
//
//        // search in second half
//        if(target >= matrix[rowStart][columnMid+1] && target <= matrix[rowStart][column-1])
//            return binarySearch(matrix, rowStart, columnMid+1, column-1, target);
//
//        // search in third half
//        if(target <= matrix[rowStart+1][columnMid-1])
//            return binarySearch(matrix, rowStart+1, 0, columnMid-1, target);
//
//        // search in fourth half
//        else
//            return binarySearch(matrix, rowStart+1, columnMid+1, column-1, target);
//
//    }
//
//    // search in the row provided between the columns provided
//    static int [] binarySearch(int[][] matrix, int row, int columnStart, int columnEnd, int target) {
//        while(columnStart <= columnEnd) {
//            int mid = columnStart + (columnEnd - columnStart) / 2;
//            if(matrix[row][mid] == target)
//                return new int[]{row,mid};
//            if(matrix[row][mid] < target)
//                columnStart = mid + 1;
//            else
//                columnEnd = mid - 1;
//        }
//        return new int[]{-1,-1};
//    }

}
