package Stack;

import java.util.Stack;

public class PrefixToInfixPostfix {

    static void prefixToInfixAndPostfix(String exp) {
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int val1 = value.pop();
                int val2 = value.pop();
                int val = operation(val1, val2, ch);
                value.push(val);

                String infixVal1 = infix.pop();
                String infixVal2 = infix.pop();
                String infixVal = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixVal);

                String postfixVal1 = postfix.pop();
                String postfixVal2 = postfix.pop();
                String postfixVal = postfixVal1 + postfixVal2 + ch;
                postfix.push(postfixVal);
            } else {
                value.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }

        }

        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());

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
        String exp = "-+2/*6483";
        prefixToInfixAndPostfix(exp);
    }

}
