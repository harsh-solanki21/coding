package Queue;

public class Queue {

    // Queue is FIFO
    static class CustomQueue {
        int[] data;
        int front;
        int size;

        CustomQueue(int max) {
            data = new int[max];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < data.length; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }

        public static void main(String[] args) {
            CustomQueue cq = new CustomQueue(5);
            cq.add(10);
            cq.add(20);
            cq.add(30);
            cq.add(40);
            cq.add(50);
            System.out.println(cq.size());
            cq.display();
            System.out.println(cq.remove());
            System.out.println(cq.remove());
            System.out.println(cq.peek());
            cq.display();
            cq.add(60);
            cq.display();
        }

    }
}
