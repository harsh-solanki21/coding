package Matrices;

public class MatrixMultiplication {

    static void multiplication(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Invalid Input");
            return;
        }
        int[][] ans = new int[a.length][b[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}};
        multiplication(a, b);
    }

}
