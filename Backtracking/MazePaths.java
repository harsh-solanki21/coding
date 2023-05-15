package Backtracking;

import java.util.ArrayList;

public class MazePaths {

    // sr - sourceRow, sc = sourceColumn, dr - destinationRow, dc - destinationColumn
    static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dr) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> horizontalPaths = new ArrayList<>();
        ArrayList<String> verticalPaths = new ArrayList<>();

        if (sc < dc) {
            horizontalPaths = getMazePaths(sr, sc + 1, dr, dc);
        }

        if (sr < dr) {
            verticalPaths = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();
        for (String hp : horizontalPaths) {
            paths.add("h" + hp);
        }
        for (String vp : verticalPaths) {
            paths.add("v" + vp);
        }

        return paths;

    }


    static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, ans + "h");
        printMazePaths(sr + 1, sc, dr, dc, ans + "v");
    }


    public static void main(String[] args) {
        System.out.println(getMazePaths(1, 1, 3, 3));  // 0 to 2 for 0 based indexing
        printMazePaths(1, 1, 3, 3, "");
    }

}
