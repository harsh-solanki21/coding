package Stack;

public class TwoStackArray {

    static class TwoStack {

        int[] data;
        int st1;
        int st2;

        TwoStack(int capacity) {
            data = new int[capacity];
            st1 = -1;
            st2 = data.length;
        }

        int size1() {
            return st1 + 1;
        }

        int size2() {
            return data.length - st2;
        }

        void push1(int val) {
            if (st2 == st1 + 1) {
                System.out.println("Stack Overflow");
            } else {
                st1++;
                data[st1] = val;
            }
        }

        void push2(int val) {
            if (st2 == st1 + 1) {
                System.out.println("Stack Overflow");
            } else {
                st2--;
                data[st2] = val;
            }
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[st1];
                st1--;
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[st2];
                st2++;
                return val;
            }
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[st1];
                return val;
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[st2];
                return val;
            }
        }

    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack(5);
        ts.push1(10);
        ts.push1(20);
        ts.push1(30);
        ts.push2(40);

        System.out.println(ts.size1());
        System.out.println(ts.size2());

        System.out.println(ts.top1());
        System.out.println(ts.top2());

        System.out.println(ts.pop1());
        System.out.println(ts.size1());

        ts.push2(50);
        ts.push2(60);
        System.out.println(ts.top2());

        ts.push1(70);

    }

}
