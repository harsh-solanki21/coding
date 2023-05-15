package Matrices;

public class FindAllOccurrencesOfWord {

    // Time Complexity: O(row x column)
    // Auxiliary Space: O(row x column)

    static final int ROW = 3;
    static final int COL = 5;

    static boolean isvalid(int row, int col, int prevRow, int prevCol) {
        // return true if row number and column number is in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !(row == prevRow && col == prevCol);
    }


    static int[] rowNum = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] colNum = {-1, 0, 1, -1, 1, -1, 0, 1};


    static void DFS(char[][] mat, int row, int col, int prevRow, int prevCol, char[] word, String path, int index, int n) {
        if (index > n || mat[row][col] != word[index]) {
            return;
        }

        path += (word[index]) + "(" + String.valueOf(row) + ", " + String.valueOf(col) + ") ";

        if (index == n) {
            System.out.println(path);
            return;
        }

        for (int k = 0; k < 8; ++k) {
            if (isvalid(row + rowNum[k], col + colNum[k], prevRow, prevCol)) {
                DFS(mat, row + rowNum[k], col + colNum[k], row, col, word, path, index + 1, n);
            }
        }
    }


    static void findWords(char[][] mat, char[] word, int n) {
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                // occurrence of first character in matrix
                if (mat[i][j] == word[0]) {
                    DFS(mat, i, j, -1, -1, word, "", 0, n); // check and print if path exists
                }
            }
        }

    }


    public static void main(String[] args) {
        char[][] mat = {{'B', 'N', 'E', 'Y', 'S'},
                {'H', 'E', 'D', 'E', 'S'},
                {'S', 'G', 'N', 'D', 'E'}};

        char[] word = "DES".toCharArray();

        findWords(mat, word, word.length - 1);
    }

}
