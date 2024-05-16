package Graphs.Algorithms.DisjointSet;

public class PathCompression {

    // TC - O(log n)
    private int[] parent;

    public PathCompression(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // O(log n)
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]); // Path compression
        return parent[i];
    }

    public void union(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);

        if (iLeader != jLeader) {
            parent[jLeader] = iLeader;
        }
    }

    public static void main(String[] args) {
        int size = 5;
        PathCompression uf = new PathCompression(size);

        uf.union(1, 2);  // 1 <-- 2
        uf.union(3, 4);  // 3 <-- 4

        System.out.println("Are 1 and 2 in the same set? " + (uf.find(1) == uf.find(2)));

        System.out.println("Are 2 and 4 in the same set? " + (uf.find(2) == uf.find(4)));
        uf.union(2, 4);  // 2 --> 1 <-- 3 <-- 4 (Union of leaders i.e. 1 & 3)
        System.out.println("\nAre 2 and 4 in the same set? " + (uf.find(2) == uf.find(4)));
    }

}
