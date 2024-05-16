package Graphs.Algorithms.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    // TC - O(α(n))
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int find(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int leader = find(parent.get(node));
        parent.set(node, leader);
        return parent.get(node);
    }

    public void unionByRank(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (rank.get(iLeader) < rank.get(jLeader)) {
            parent.set(iLeader, jLeader);
        } else if (rank.get(iLeader) > rank.get(jLeader)) {
            parent.set(jLeader, iLeader);
        } else {
            parent.set(jLeader, iLeader);
            int rankU = rank.get(iLeader);
            rank.set(iLeader, rankU + 1);
        }
    }

    public void unionBySize(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (size.get(iLeader) < size.get(jLeader)) {
            parent.set(iLeader, jLeader);
            size.set(jLeader, size.get(jLeader) + size.get(iLeader));
        } else {
            parent.set(jLeader, iLeader);
            size.set(iLeader, size.get(iLeader) + size.get(jLeader));
        }
    }

}

class Main {

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        // Union By Rank
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.find(3) == ds.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        ds.unionByRank(3, 7);
        if (ds.find(3) == ds.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }


        // Union By Size
//        ds.unionBySize(1, 2);
//        ds.unionBySize(2, 3);
//        ds.unionBySize(4, 5);
//        ds.unionBySize(6, 7);
//        ds.unionBySize(5, 6);
//
//        if (ds.find(3) == ds.find(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }
//
//        ds.unionBySize(3, 7);
//        if (ds.find(3) == ds.find(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }

    }

}
