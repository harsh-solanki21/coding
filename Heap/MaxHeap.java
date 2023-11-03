package Heap;

public class MaxHeap {

    private int[] heap;
    private int size;

    MaxHeap(int capacity) {
        this.heap = new int[capacity + 1];
        this.heap[0] = Integer.MAX_VALUE;
        this.size = 0;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int leftChild(int position) {
        return (2 * position);
    }

    private int rightChild(int position) {
        return (2 * position) + 1;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private void downHeapify(int position) {
        if (position >= (size / 2) && position <= size) {
            return;
        }

        if (heap[position] < heap[leftChild(position)] || heap[position] < heap[rightChild(position)]) {
            if (heap[leftChild(position)] > heap[rightChild(position)]) {
                swap(position, leftChild(position));
                downHeapify(leftChild(position));
            } else {
                swap(position, rightChild(position));
                downHeapify(rightChild(position));
            }
        }
    }

    private void upHeapify(int position) {
        int temp = heap[position];
        while (position > 0 && temp > heap[parent(position)]) {
            heap[position] = heap[parent(position)];
            position = parent(position);
        }
        heap[position] = temp;
    }


    public void insert(int element) {
        heap[++size] = element;
        int current = size;
        upHeapify(current);
    }

    public void display() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(heap[i] + ": L- " + heap[2 * i] + " R- " + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractMax() {
        int max = heap[1];
        heap[1] = heap[size--];
        downHeapify(1);
        return max;
    }


    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(13);
        maxHeap.insert(6);
        maxHeap.insert(17);

        maxHeap.display();
        System.out.println("The max is " + maxHeap.extractMax());
    }

}
