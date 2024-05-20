package Graphs.Algorithms.DisjointSet;

public class MostOptimized {

    // TC - O(α(n)), SC - O(n)
    // Path compression with union by size / rank
    private int[] parent;
    private int[] rank;
    private int[] size;

    public MostOptimized(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]); // Path compression
        return parent[i];
    }

    void unionBySize(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (size[iLeader] < size[jLeader]) {
            parent[iLeader] = jLeader;
            size[jLeader] += size[iLeader];
        } else {
            parent[jLeader] = iLeader;
            size[iLeader] += size[jLeader];
        }

//        if (iLeader != jLeader) {
//            if (size[iLeader] < size[jLeader]) {
//                swap(size, iLeader, jLeader);
//            }
//            parent[jLeader] = iLeader;
//            size[iLeader] += size[jLeader];
//        }
    }

    void unionByRank(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (rank[iLeader] < rank[jLeader]) {
            parent[jLeader] = iLeader;
        } else if (rank[iLeader] > rank[jLeader]) {
            parent[iLeader] = jLeader;
        } else {
            parent[jLeader] = iLeader;
            rank[iLeader]++;
        }

//        if (iLeader != jLeader) {
//            if (rank[iLeader] < rank[jLeader]) {
//                swap(rank, iLeader, jLeader);
//            }
//            parent[jLeader] = iLeader;
//            if (rank[i] == rank[j]) {
//                rank[i]++;
//            }
//        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int size = 7;
        MostOptimized mo = new MostOptimized(size);

        // Union by Size
        mo.unionBySize(1, 2);
        mo.unionBySize(2, 3);
        mo.unionBySize(4, 5);
        mo.unionBySize(6, 7);
        mo.unionBySize(5, 6);

        if (mo.find(3) == mo.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        mo.unionBySize(3, 7);
        if (mo.find(3) == mo.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }


        // Union By Rank
//        mo.unionByRank(1, 2);
//        mo.unionByRank(2, 3);
//        mo.unionByRank(4, 5);
//        mo.unionByRank(6, 7);
//        mo.unionByRank(5, 6);
//
//        if (mo.find(3) == mo.find(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }
//
//        mo.unionByRank(3, 7);
//        if (mo.find(3) == mo.find(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }

    }

}
