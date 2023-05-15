package RecursionMedium;

import java.util.ArrayList;

public class ParenthesesCombinations {

    // Print all combinations of balanced parentheses
    // TC = O(2^n), SC = O(n)
    static void printParenthesis(char[] str, int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            if (open > close) {
                str[pos] = ')';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '(';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    static void parenthesis(char[] str, int n) {
        if (n > 0)
            printParenthesis(str, 0, n, 0, 0);
    }


    // Recursive
    static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }
        if (open < n)
            generateParenthesis(n, open + 1, close, s + "(", ans);

        if (close < open)
            generateParenthesis(n, open, close + 1, s + ")", ans);
    }


    public static void main(String[] args) {
        // First Approach
        int n = 3;
        char[] str = new char[2 * n];
        parenthesis(str, n);

        System.out.println();

        // Second Approach
        ArrayList<String> ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", ans);
        for (String s : ans) {
            System.out.println(s);
        }

    }

}
