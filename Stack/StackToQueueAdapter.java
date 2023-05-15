package Stack;

import java.util.Stack;

public class StackToQueueAdapter {

    static class StackQueueAdapter {

        Stack<Integer> st;
        Stack<Integer> helper;

        StackQueueAdapter() {
            st = new Stack<>();
            helper = new Stack<>();
        }


        // remove and peek efficient Solution

        int size() {
            return st.size();
        }

//        void add(int val) {
//            while (st.size() > 0) {
//                helper.push(st.pop());
//            }
//
//            st.push(val);
//
//            while (helper.size() > 0) {
//                st.push(helper.pop());
//            }
//
//        }
//
//        int remove() {
//            if (size() == 0) {
//                System.out.println("Queue Underflow");
//                return -1;
//            } else {
//                return st.pop();
//            }
//        }
//
//        int peek() {
//            if (size() == 0) {
//                System.out.println("Queue Underflow");
//                return -1;
//            } else {
//                return st.peek();
//            }
//        }


        // add efficient Solution

        void add(int val) {
            st.push(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (st.size() > 1) {
                    helper.push(st.pop());
                }

                int val = st.pop();

                while (helper.size() > 0) {
                    st.push(helper.pop());
                }

                return val;
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (st.size() > 1) {
                    helper.push(st.pop());
                }

                int val = st.pop();
                helper.push(val);

                while (helper.size() > 0) {
                    st.push(helper.pop());
                }

                return val;
            }
        }

    }

}
