package Graphs;

import java.util.Arrays;

public class SurroundedRegions {

    // https://leetcode.com/problems/surrounded-regions/description/

    static void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0, j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'O' && !visited[i][j]) {
                dfs(board, visited, i, j);
            }
        }

        for (int i = 0, j = board[0].length - 1; i < board.length; i++) {
            if (board[i][j] == 'O' && !visited[i][j]) {
                dfs(board, visited, i, j);
            }
        }

        for (int i = board.length - 1, j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'O' && !visited[i][j]) {
                dfs(board, visited, i, j);
            }
        }

        for (int i = 0, j = 0; i < board.length; i++) {
            if (board[i][j] == 'O' && !visited[i][j]) {
                dfs(board, visited, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        solve(board);
        for (char[] i : board) {
            System.out.println(Arrays.toString(i));
        }
    }

}
