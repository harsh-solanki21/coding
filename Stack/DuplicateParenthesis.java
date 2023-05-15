package Stack;

import java.util.Stack;

public class DuplicateParenthesis {

    static void findDuplicateParenthesis(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    System.out.println("Duplicates found");
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        System.out.println("No Duplicates Found");
    }


    public static void main(String[] args) {
        findDuplicateParenthesis("(((a+(b))+(c+d)))");
        findDuplicateParenthesis("((a+b)+(a-b))");
        findDuplicateParenthesis("(a+b)+((c+d))");
    }

}
