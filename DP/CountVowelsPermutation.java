package DP;

public class CountVowelsPermutation {

    static int countVowelPermutation(int n) {
        if (n == 0) {
            return 0;
        }

        long[][] f = new long[n][5];
        for (int j = 0; j < 5; j++) {
            f[0][j] = 1;
        }

        int a = 0, e = 1, i = 2, o = 3, u = 4;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int r = 1; r < n; r++) {
            f[r][a] = (f[r - 1][e] + f[r - 1][i] + f[r - 1][u]) % mod;
            f[r][e] = (f[r - 1][a] + f[r - 1][i]) % mod;
            f[r][i] = (f[r - 1][e] + f[r - 1][o]) % mod;
            f[r][o] = (f[r - 1][i]) % mod;
            f[r][u] = (f[r - 1][i] + f[r - 1][o]) % mod;
        }

        long ans = 0;
        for (int j = 0; j < 5; j++) {
            ans = (ans + f[n - 1][j]) % mod;
        }

        return (int) ans;
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(countVowelPermutation(n));
    }

}
