package RecursionMedium;

import java.util.ArrayList;

public class StairsPath {

    static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } else if (n < 0) {
            ArrayList<String> res = new ArrayList<>();
            return res;
        }

        ArrayList<String> paths1 = getStairPaths(n - 1);
        ArrayList<String> paths2 = getStairPaths(n - 2);
        ArrayList<String> paths3 = getStairPaths(n - 3);

        ArrayList<String> paths = new ArrayList<>();
        for (String path : paths1) {
            paths.add(1 + path);
        }
        for (String path : paths2) {
            paths.add(2 + path);
        }
        for (String path : paths3) {
            paths.add(3 + path);
        }
        return paths;
    }


    static void printStairPath(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        if (n < 0) {
            return;
        }
        printStairPath(n - 1, ans + "1");
        printStairPath(n - 2, ans + "2");
        printStairPath(n - 3, ans + "3");
    }


    static void printStairPath2(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            printStairPath2(n - i, ans + i);
        }
    }

    public static void main(String[] args) {
//        System.out.println(getStairPaths(4));
//        printStairPath(4, "");
        printStairPath2(4, "");
    }

}
