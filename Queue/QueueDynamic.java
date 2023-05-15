package Queue;

public class QueueDynamic {

    static class DynamicQueue {
        int[] data;
        int front;
        int size;

        DynamicQueue(int max) {
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
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front + i) % data.length;
                    newData[i] = data[idx];
                }
                data = newData;
                front = 0;

                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
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
            DynamicQueue dq = new DynamicQueue(5);
            dq.add(10);
            dq.add(20);
            dq.add(30);
            dq.add(40);
            dq.add(50);
            System.out.println(dq.size());
            dq.display();
            System.out.println(dq.remove());
            System.out.println(dq.remove());
            System.out.println(dq.peek());
            dq.display();
            dq.add(60);
            dq.display();
        }

    }

}
