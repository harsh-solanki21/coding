package Stack;

import java.util.Stack;

public class PostfixToInfixPrefix {

    static void postfixToInfixAndPrefix(String exp) {
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int val2 = value.pop();
                int val1 = value.pop();
                int val = operation(val1, val2, ch);
                value.push(val);

                String infixVal2 = infix.pop();
                String infixVal1 = infix.pop();
                String infixVal = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixVal);

                String prefixVal2 = prefix.pop();
                String prefixVal1 = prefix.pop();
                String prefixVal = ch + prefixVal1 + prefixVal2;
                prefix.push(prefixVal);

            } else {
                value.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }

        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());

    }

    static int operation(int val1, int val2, char op) {
        if (op == '+')
            return val1 + val2;
        else if (op == '-')
            return val1 - val2;
        else if (op == '*')
            return val1 * val2;
        else
            return val1 / val2;
    }

    public static void main(String[] args) {
        String exp = "264*8/+3-";  // postfix expression
        postfixToInfixAndPrefix(exp);
    }

}
