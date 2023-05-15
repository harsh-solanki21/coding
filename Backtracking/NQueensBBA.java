package Backtracking;

public class NQueensBBA {

    // Branch and Bound Algorithm
    static void nQueens(boolean[][] board, int row, boolean[] cols, boolean[] diag, boolean[] revDiag, String ans) {
        if (row == board.length) {
            System.out.println(ans);
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (!cols[j] && !diag[row + j] && !revDiag[row - j + board.length - 1]) {
                board[row][j] = true;
                cols[j] = true;
                diag[row + j] = true;
                revDiag[row - j + board.length - 1] = true;

                nQueens(board, row + 1, cols, diag, revDiag, ans + row + "-" + j + " ");

                board[row][j] = false;
                cols[j] = false;
                diag[row + j] = false;
                revDiag[row - j + board.length - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] revDiag = new boolean[2 * n - 1];

        nQueens(board, 0, cols, diag, revDiag, "");
    }

}
