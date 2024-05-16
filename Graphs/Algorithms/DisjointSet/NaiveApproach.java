package Graphs.Algorithms.DisjointSet;

public class NaiveApproach {

    // TC - O(n)
    private int[] parent;

    public NaiveApproach(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
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
        NaiveApproach uf = new NaiveApproach(size);

        uf.union(1, 2);  // 1 <-- 2
        uf.union(3, 4);  // 3 <-- 4

        System.out.println("Are 1 and 2 in the same set? " + (uf.find(1) == uf.find(2)));

        System.out.println("Are 2 and 4 in the same set? " + (uf.find(2) == uf.find(4)));
        uf.union(2, 4);  // 2 --> 1 <-- 3 <-- 4 (Union of leaders i.e. 1 & 3)
        System.out.println("\nAre 2 and 4 in the same set? " + (uf.find(2) == uf.find(4)));
    }

}
