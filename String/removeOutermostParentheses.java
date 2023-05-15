package String;

public class removeOutermostParentheses {

    static String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
                if (open > 1)
                    res.append(ch);
            }
            else {
                open--;
                if (open > 0)
                    res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

}
