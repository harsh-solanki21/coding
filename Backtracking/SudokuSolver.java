package Backtracking;

import java.util.Arrays;

public class SudokuSolver {

    // TC - O(9^n^2)
    static void solveSudoku(int[][] board, int i, int j) {
        if (i == board.length) {
            for (int[] nums : board) {
                System.out.println(Arrays.toString(nums));
            }
            return;
        }

        int row = 0, col = 0;
        if (j == board[0].length - 1) {
            row = i + 1;
            col = 0;
        } else {
            row = i;
            col = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, row, col);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (isValid(board, i, j, k)) {
                    board[i][j] = k;
                    solveSudoku(board, row, col);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int row, int col, int val) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == val) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        // get the corner of submatrix
        int smi = row / 3 * 3;  // sub matrix i
        int smj = col / 3 * 3;  // sub matrix j

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[smi + i][smj + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solveSudoku(board, 0, 0);

    }


}
