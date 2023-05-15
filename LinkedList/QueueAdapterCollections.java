package LinkedList;

import java.util.LinkedList;

public class QueueAdapterCollections {

    LinkedList<Integer> list;

    QueueAdapterCollections() {
        list = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void add(int data) {
        list.addLast(data);
    }

    int remove() {
        if(size() == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        else
            return list.removeFirst();
    }

    int peek() {
        if(size() == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        else
            return list.getFirst();
    }

    public static void main(String[] args) {
        QueueAdapterCollections qac = new QueueAdapterCollections();
        qac.add(10);
        qac.add(20);
        qac.add(30);
        qac.add(40);
        System.out.println(qac.peek());
        System.out.println(qac.size());
        System.out.println(qac.remove());
        System.out.println(qac.remove());
        System.out.println(qac.remove());
        System.out.println(qac.peek());
        System.out.println(qac.size());
    }

}
