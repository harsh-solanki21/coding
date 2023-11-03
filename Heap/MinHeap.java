package Heap;

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int size;
    private final int capacity;

    MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }


    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int leftChild(int i) {
        return (2 * i + 1);
    }

    static int rightChild(int i) {
        return (2 * i + 2);
    }

    static int getMin(MinHeap minHeap) {
        return minHeap.heap[0];
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= capacity || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void insert(int element) {
        if (size >= capacity) {
            return;
        }
        heap[size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int remove() {
        int popped = heap[0];
        heap[0] = heap[--size];
        minHeapify(0);
        return popped;
    }

    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
                if (heap[leftChild(i)] < heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    public void minHeap() {
        for (int i = (size - 1) / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < (size / 2); i++) {
            System.out.print("Parent : " + heap[i]);
            if (leftChild(i) < size) {
                System.out.print(" Left : " + heap[leftChild(i)]);
            }
            if (rightChild(i) < size) {
                System.out.print(" Right : " + heap[rightChild(i)]);
            }
            System.out.println();
        }
    }

    private void swap(int first, int second) {
        int tmp = heap[first];
        heap[first] = heap[second];
        heap[second] = tmp;
    }


    public static void main(String[] arg) {
        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(3);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(16);
        minHeap.insert(21);
        minHeap.insert(12);
        minHeap.insert(9);
        minHeap.minHeap();

        System.out.println("The Min Heap is : " + Arrays.toString(minHeap.heap));
        minHeap.printHeap();
        System.out.println("\nThe Min Value is : " + minHeap.remove());
        System.out.println("\nThe Min Heap is :" + Arrays.toString(minHeap.heap));
        minHeap.printHeap();
    }


}
