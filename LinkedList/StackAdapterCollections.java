package LinkedList;

import java.util.LinkedList;

public class StackAdapterCollections {

    LinkedList<Integer> list;

    StackAdapterCollections() {
        list  = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void push(int data) {
        list.addFirst(data);
    }

    int pop() {
        if(size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
            return list.removeFirst();
    }

    int peek() {
        if(size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
            return list.getFirst();
    }

    public static void main(String[] args) {
        StackAdapterCollections sac = new StackAdapterCollections();
        sac.push(40);
        sac.push(30);
        sac.push(20);
        sac.push(10);
        System.out.println(sac.peek());
        System.out.println(sac.size());
        System.out.println(sac.pop());
        System.out.println(sac.pop());
        System.out.println(sac.pop());
        System.out.println(sac.peek());
        System.out.println(sac.size());
    }

}
