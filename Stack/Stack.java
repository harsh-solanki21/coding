package Stack;

public class Stack {

    // Stack is LIFO
    static class CustomStack {
        int[] data;
        int top;

        CustomStack(int max) {
            data = new int[max];
            top = -1;
        }

        int size() {
            return top + 1;
        }

        void display() {
            for (int i = top; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (top == data.length - 1) {
                System.out.println("Stack Overflow");
            } else {
                top++;
                data[top] = val;
            }
        }

        int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[top];
                top--;
                return val;
            }
        }

        int peek() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data[top];
            }
        }

        public static void main(String[] args) {
            CustomStack st = new CustomStack(10);
            st.push(10);
            st.push(20);
            st.push(30);
            System.out.println(st.pop() + " Popped from stack");
            System.out.println("Top element is: " + st.peek());
            System.out.println("Size of Stack: " + st.size());
            System.out.print("Elements present in stack: ");
            st.display();
        }

    }

    // Stack Implementation
//    static final int MAX = 1000;
//    int top;
//    int[] a = new int[MAX]; // Maximum size of Stack
//
//    boolean isEmpty() {
//        return (top < 0);
//    }
//
//    Stack() {
//        top = -1;
//    }
//
//    boolean push(int x) {
//        if (top >= (MAX - 1)) {
//            System.out.println("Stack Overflow");
//            return false;
//        } else {
//            a[++top] = x;
//            System.out.println(x + " pushed into stack");
//            return true;
//        }
//    }
//
//    int pop() {
//        if (top < 0) {
//            System.out.println("Stack Underflow");
//            return 0;
//        } else {
//            int x = a[top--];
//            return x;
//        }
//    }
//
//    int peek() {
//        if (top < 0) {
//            System.out.println("Stack Underflow");
//            return 0;
//        } else {
//            return a[top];
//        }
//    }
//
//    void print() {
//        for (int i = top; i > -1; i--) {
//            System.out.print(" " + a[i]);
//        }
//    }
//
//    public static void main(String args[]) {
//        Stack s = new Stack();
//        s.push(10);
//        s.push(20);
//        s.push(30);
//        System.out.println(s.pop() + " Popped from stack");
//        System.out.println("Top element is :" + s.peek());
//        System.out.print("Elements present in stack :");
//        s.print();
//    }

}
