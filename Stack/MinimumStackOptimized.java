package Stack;

import java.util.Stack;

public class MinimumStackOptimized {

    // Using single stack
    // TC - O(1), SC - O(1)

    static class MinStack {
        Stack<Integer> st;
        int min;

        MinStack() {
            st = new Stack<>();
        }


        int size() {
            return st.size();
        }


        int min() {
            if (st.size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return min;
            }
        }


        int peek() {
            if (st.size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if (st.peek() >= min)
                    return st.peek();
                else
                    return min;
            }
        }


        int pop() {
            if (st.size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int val = st.pop();
            if (val < min) {
                int oldVal = min;
                min = 2 * min - val;
                return oldVal;
            } else {
                return val;
            }

        }


        void push(int val) {
            if (st.size() == 0) {
                st.push(val);
                min = val;
            } else if (val < min) {
                st.push(2 * val - min);  // this value will be smaller than min
                min = val;
            } else {
                st.push(val);
            }

        }
    }


    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(3);
        st.push(5);
        System.out.println(st.min());
        st.push(2);
        st.push(1);
        System.out.println(st.size());
        System.out.println(st.min());
        System.out.println(st.pop());
        System.out.println(st.min());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.size());
    }


}
