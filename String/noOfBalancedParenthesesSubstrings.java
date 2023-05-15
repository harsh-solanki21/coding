package String;

public class noOfBalancedParenthesesSubstrings {

    // TC = O(n)
    public static int BalancedSubstring(String s, int n) {
        int ans = 0;
        int[] arr = new int[n / 2 + 1];
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                d++;
            else {
                if (d == 1) {
                    for (int j = 2; j <= n / 2 + 1 && arr[j] != 0; j++) {
                        arr[j] = 0;
                    }
                }
                ++ans;
                ans += arr[d];
                arr[d]++;
                d--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "()()()";
        int n = str.length();
        System.out.println(BalancedSubstring(str, n));
    }

}
