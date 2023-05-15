package String;

public class validParentheses {

    static int minParentheses(String s) {
        int bal = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (bal == -1) {
                ans += 1;
                bal += 1;
            }
        }
        return bal + ans;
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minParentheses(s));
    }

}
