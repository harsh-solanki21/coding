package Stack;

public class StackDynamic {

    static class DynamicStack {
        int[] data;
        int top;

        DynamicStack(int max) {
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
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
                top++;
                data[top] = val;
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
            DynamicStack st = new DynamicStack(10);
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

}
