package Heap;

public class Deletion {

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static int deleteRoot(int[] heap, int n) {
        int lastElement = heap[n - 1];
        heap[0] = lastElement;
        n = n - 1;

        heapify(heap, n, 0);

        return n;
    }

    static void printHeap(int[] heap, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(heap[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] heap = {10, 5, 3, 2, 4};
        int n = heap.length;

        n = deleteRoot(heap, n);

        printHeap(heap, n);
    }

}
