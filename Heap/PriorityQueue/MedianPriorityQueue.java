package Heap.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianPriorityQueue {

    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    void add(int val) {
        if (!right.isEmpty() && val > right.peek()) {
            right.add(val);
        } else {
            left.add(val);
        }

        if (left.size() - right.size() == 2) {
            right.add(left.remove());
        } else if (right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }

    int remove() {
        if (size() == 0) {
            return -1;
        } else if (left.size() >= right.size()) {
            return left.remove();
        } else {
            return right.remove();
        }
    }

    int peek() {
        if (size() == 0) {
            return -1;
        } else if (left.size() >= right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }

    int size() {
        return left.size() + right.size();
    }

    public static void main(String[] args) {
        MedianPriorityQueue med = new MedianPriorityQueue();
        med.add(10);
        med.add(60);
        med.add(50);
        med.add(20);
        med.add(40);
        med.add(5);

        System.out.println(med.peek());
    }

}
