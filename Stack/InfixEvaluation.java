package Stack;

import java.util.Stack;

public class InfixEvaluation {

    static void infixEvaluation(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opVal = operation(v1, v2, optor);
                    operands.push(opVal);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opVal = operation(v1, v2, optor);
                    operands.push(opVal);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            char optor = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int opVal = operation(v1, v2, optor);
            operands.push(opVal);
        }

        System.out.println(operands.peek());

    }

    static int precedence(char operator) {
        if (operator == '+')
            return 1;
        else if (operator == '-')
            return 1;
        else if (operator == '*')
            return 2;
        else
            return 2;
    }

    static int operation(int a, int b, char operator) {
        if (operator == '+')
            return a + b;
        else if (operator == '-')
            return a - b;
        else if (operator == '*')
            return a * b;
        else
            return a / b;
    }


    public static void main(String[] args) {
        String exp = "2+(5-3*6/2)";
        infixEvaluation(exp);
    }

}
