package Stack;

import java.util.Stack;

public class MinimumStack {

    static class MinStack {

        Stack<Integer> st;
        Stack<Integer> min;

        MinStack() {
            st = new Stack<>();
            min = new Stack<>();
        }

        int size() {
            return st.size();
        }

        void push(int val) {
            st.push(val);

            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = st.pop();
                if (val == min.peek()) {
                    min.pop();
                }
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return st.peek();
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return min.peek();
            }
        }

    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(8);
        ms.push(4);
        ms.push(11);
        ms.push(5);
        System.out.println(ms.size());
        System.out.println(ms.top());
        System.out.println(ms.min());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.size());
        System.out.println(ms.top());
        System.out.println(ms.min());
    }

}
