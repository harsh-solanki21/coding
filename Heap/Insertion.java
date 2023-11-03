package Heap;

public class Insertion {

    // TC - O(log n)
    static int insertNode(int[] heap, int n, int Key) {
        n = n + 1;
        heap[n - 1] = Key;

        heapify(heap, n, n - 1);

        return n;
    }

    private static void heapify(int[] arr, int n, int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0) {
            if (arr[i] > arr[parent]) {
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                heapify(arr, n, parent);
            }
        }
    }

    static void printHeap(int[] heap, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        int capacity = 100;
        int[] heap = new int[capacity];
        heap[0] = 10;
        heap[1] = 5;
        heap[2] = 3;
        heap[3] = 2;
        heap[4] = 4;

        int n = 5;
        int Key = 15;

        n = insertNode(heap, n, Key);

        printHeap(heap, n);

    }

}
