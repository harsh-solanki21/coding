package Matrices;

public class DiagonalWaveTraversal {

    static int[] diagonalWaveTraversal(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int count = 0;
        int[] ans = new int[row * col];
        int i = 0, j = 0;
        while (i < row + col - 1) {
            if (i % 2 == 0) {
                while (j < col && j <= i) {
                    ans[count++] = mat[i - j][j];
                    j++;
                }
                j = j == col ? i - j + 2 : 0;
            }
            else {
                while (j < row && j <= i) {
                    ans[count++] = mat[j][i - j];
                    j++;
                }
                j = j == row ? i - j + 2 : 0;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ans = diagonalWaveTraversal(mat);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
