package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapter {

    static class QueueStackAdapter {

        Queue<Integer> q;
        Queue<Integer> helper;

        QueueStackAdapter() {
            q = new ArrayDeque<>();
            helper = new ArrayDeque<>();
        }


        // pop and peek efficient Solution

        int size() {
            return q.size();
        }

        void push(int val) {
            while (q.size() > 0) {
                helper.add(q.remove());
            }

            q.add(val);

            while (helper.size() > 0) {
                q.add(helper.remove());
            }
        }

        int pop() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return q.remove();
            }
        }

        int top() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return q.peek();
            }
        }




        // push efficient Solution

//        void push(int val) {
//            q.add(val);
//        }
//
//        int pop() {
//            while (q.size() > 1) {
//                helper.add(q.remove());
//            }
//
//            int val = q.remove();
//
//            while (helper.size() > 0) {
//                q.add(helper.remove());
//            }
//
//            return val;
//        }
//
//        int top() {
//            if (size() == 0) {
//                System.out.println("Stack Underflow");
//                return -1;
//            } else {
//                while (q.size() > 1) {
//                    helper.add(q.remove());
//                }
//
//                int val = q.remove();
//                helper.add(val);
//
//                while (helper.size() > 0) {
//                    q.add(helper.remove());
//                }
//
//                return val;
//            }
//        }

    }

}
