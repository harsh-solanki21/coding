package Backtracking;

public class Subsequences {

    // Power Set: Print all the possible subsequences of the String
    static void powerSet(String s, String ans) {
        if (s.isEmpty()) {
            System.out.print(ans + " ");
            return;
        }
        powerSet(s.substring(1), ans + s.charAt(0));
        powerSet(s.substring(1), ans);
    }

    public static void main(String[] args) {
        String s = "abc";
        String ans = "";
        powerSet(s, ans);
    }

}
