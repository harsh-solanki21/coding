package GreedyAlgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

    // Huffman coding is a lossless data compression algorithm.
    // TC - O(n * log n)
    // SC - O(n)
    // where n is the number of unique characters. If there are n nodes, extractMin() is called 2*(n – 1) times.
    // extractMin() takes O(log n) time as it calls minHeapify().
    // So, the overall complexity is O(n * log n).

    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;
    }

    static class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.data - y.data;
        }
    }

    static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " | " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }


    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }

        System.out.println("Char | Huffman code");
        System.out.println("-------------------");
        printCode(root, "");
    }

}
