package Stack;

import java.util.Stack;

public class BalancedBrackets {

    static boolean balancedBrackets(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (ch == ')') {
                if (st.peek() == '(')
                    st.pop();
                else
                    return false;
            }
            else if (ch == '}') {
                if (st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
            else if (ch == ']') {
                if (st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(balancedBrackets("[(a+b) + {(c+d) * (e/f)}]"));
        System.out.println(balancedBrackets("[(a+b) + {(c+d) * (e/f)]}"));
    }


}
