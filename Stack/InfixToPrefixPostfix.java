package Stack;

import java.util.Stack;

public class InfixToPrefixPostfix {

    // Infix    (the way humans understand and calculate)
    // Prefix   (first operators come and then operands)  (the way machine understand and calculates)
    // Postfix  (first operands come and then operators)  (the way machine understand and calculates)

    // Infix   - v1v2op (a+b)
    // Prefix  - opv1v2 (+ab)
    // Postfix - v1v2op (ab+)

    static void infixToPrefixAndpostfix(String exp) {
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "d");
                pre.push(ch + "d");
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    char op = ops.pop();

                    String postVal2 = post.pop();
                    String postVal1 = post.pop();
                    String postVal = postVal1 + postVal2 + op;
                    post.push(postVal);

                    String preVal2 = pre.pop();
                    String preVal1 = pre.pop();
                    String preVal = op + preVal1 + preVal2;
                    pre.push(preVal);
                }

                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();

                    String postVal2 = post.pop();
                    String postVal1 = post.pop();
                    String postVal = postVal1 + postVal2 + op;
                    post.push(postVal);

                    String preVal2 = pre.pop();
                    String preVal1 = pre.pop();
                    String preVal = op + preVal1 + preVal2;
                    pre.push(preVal);
                }

                ops.push(ch);
            }
        }

        while (ops.size() > 0) {
            char op = ops.pop();

            String postVal2 = post.pop();
            String postVal1 = post.pop();
            String postVal = postVal1 + postVal2 + op;
            post.push(postVal);

            String preVal2 = pre.pop();
            String preVal1 = pre.pop();
            String preVal = op + preVal1 + preVal2;
            pre.push(preVal);
        }

        System.out.println(pre.pop());
        System.out.println(post.pop());

    }

    static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else  // code will never come here
            return 0;
    }

    public static void main(String[] args) {
        String exp = "2+(5-3*6/2)";
        infixToPrefixAndpostfix(exp);
    }

}
