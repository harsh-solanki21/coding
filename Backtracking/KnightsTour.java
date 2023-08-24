package Backtracking;

public class KnightsTour {

    // Given an N*N board with the Knight placed on a block(or the first block) of an empty board.
    // Moving according to the rules of chess knight must visit each square exactly once.
    // Print the order of each cell in which they are visited.
    static void knightsTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        knightsTour(chess, row - 2, col + 1, move + 1);
        knightsTour(chess, row - 1, col + 2, move + 1);
        knightsTour(chess, row + 1, col + 2, move + 1);
        knightsTour(chess, row + 2, col + 1, move + 1);
        knightsTour(chess, row + 2, col - 1, move + 1);
        knightsTour(chess, row + 1, col - 2, move + 1);
        knightsTour(chess, row - 1, col - 2, move + 1);
        knightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    // displays all the possible knight positions(where they don't attack each other) where we can place n nights on the NxN chess board
    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = 5;
        int row = 0, col = 0;  // where knight will be placed initially (it can be anywhere on the board)
        int[][] chess = new int[n][n];
        knightsTour(chess, row, col, 1);

//        int n = 4;
//        boolean[][] board = new boolean[n][n];
//        knight(board, 0, 0, 4);
    }

}
