package RecursionMedium;

public class LexicographicalNumbers {

    // You are given a number.
    // You have to print all the numbers from 1 to n in lexicographical order.

    static void lexicographical(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
    }

    private static void dfs(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10 * i + j, n);
        }
    }

    public static void main(String[] args) {
        int n = 30;
        lexicographical(n);
    }

}
