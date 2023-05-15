package Backtracking;

import java.util.ArrayList;

public class MazePathsWithJumps {

    // sr - sourceRow, sc = sourceColumn, dr - destinationRow, dc - destinationColumn
    static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dr) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> paths = new ArrayList<>();

        // horizontal moves
        for (int i = 1; i <= dc - sc; i++) {
            ArrayList<String> horizontalPaths = getMazePaths(sr, sc + i, dr, dc);
            for (String path : horizontalPaths) {
                paths.add("h" + i + path);
            }
        }

        // vertical moves
        for (int i = 1; i <= dr - sr; i++) {
            ArrayList<String> verticalPaths = getMazePaths(sr + i, sc, dr, dc);
            for (String path : verticalPaths) {
                paths.add("v" + i + path);
            }
        }

        // diagonal moves
        for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
            ArrayList<String> diagonalPaths = getMazePaths(sr + i, sc + i, dr, dc);
            for (String path : diagonalPaths) {
                paths.add("d" + i + path);
            }
        }

        return paths;

    }


    static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {

        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        // horizontal moves
        for (int i = 1; i <= dc - sc; i++) {
            printMazePaths(sr, sc + i, dr, dc, ans + "h" + i);
        }

        // vertical moves
        for (int i = 1; i <= dr - sr; i++) {
            printMazePaths(sr + i, sc, dr, dc, ans + "v" + i);
        }

        // diagonal moves
        for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
            printMazePaths(sr + i, sc + i, dr, dc, ans + "d" + i);
        }

    }


    public static void main(String[] args) {
//        System.out.println(getMazePaths(1, 1, 3, 3));  // 0 to 2 for 0 based indexing
        printMazePaths(1, 1, 3, 3, "");
    }

}
