package Backtracking;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
    // Queens can attack vertically, horizontally and diagonally.

    // displays coordinates where we can put queens on the board
    static void printNQueens(int[][] chess, String ans, int row) {
        if (row == chess.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (isItSafeForQueen(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, ans + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isItSafeForQueen(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    // displays the chess board placed with queens
    // also displays no. of ways possible to place queens on the board
    // TC - O(n^3 * n!)
    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    // Leetcode solution with List<List<String>> return type
    static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] rowArr = new int[n];
        int[] downDigArr = new int[2 * n - 1];
        int[] upDigArr = new int[2 * n - 1];
        List<List<String>> list = new ArrayList<>();
        solve(board, 0, n, list, rowArr, upDigArr, downDigArr);

        return list;
    }

    private static void solve(char[][] board, int col, int n, List<List<String>> list, int[] rowArr, int[] upDigArr, int[] downDigArr) {
        if (col == n) {
            List<String> ds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ds.add(new String(board[i]));
            }
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (rowArr[row] == 0 && downDigArr[row + col] == 0 && upDigArr[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                rowArr[row] = 1;
                downDigArr[row + col] = 1;
                upDigArr[n - 1 + col - row] = 1;
                solve(board, col + 1, n, list, rowArr, upDigArr, downDigArr);
                board[row][col] = '.';
                rowArr[row] = 0;
                downDigArr[row + col] = 0;
                upDigArr[n - 1 + col - row] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int n = 4;  // n = 2 and 3 will give blank output because there is no answer for those inputs
        int[][] chess = new int[n][n];
//        printNQueens(chess, "", 0);

        boolean[][] board = new boolean[n][n];
//        queens(board, 0);
//        System.out.println(queens(board, 0));  // total no. of ways possible to put queen

        List<List<String>> ans = solveNQueens(n);
        System.out.println(ans);
    }

}
