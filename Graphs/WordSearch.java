package Graphs;

public class WordSearch {

    // https://leetcode.com/problems/word-search/

    static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '0';

        if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
                || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
            return true;
        }

        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

}
