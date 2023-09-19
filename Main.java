import java.util.*;

public class Main {

    // write solution without taking String in parameter (33)
    static ArrayList<String> mazePath(int sr, int sc, int dr, int dc, String ans) {
        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        if (sr == dr && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add(ans);
            return res;
        }

        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> down = new ArrayList<>();
        ArrayList<String> diag = new ArrayList<>();
        for (int i = 1; i < dr; i++) {
            right = mazePath(sr, sc + 1, dr, dc, ans + "H");
        }
        for (int i = 1; i < dc; i++) {
            down = mazePath(sr + 1, sc, dr, dc, ans + "V");
        }
        for (int i = 1; i < dr && i < dc; i++) {
            diag = mazePath(sr + 1, sc + 1, dr, dc, ans + "D");
        }

        right.addAll(down);
        right.addAll(diag);
        return right;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = mazePath(1, 1, 4, 4, "");
        System.out.println(ans);
    }

}