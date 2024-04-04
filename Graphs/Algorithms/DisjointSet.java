package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    // Disjoint Set (Union-Find Algorithm)
    // Two sets are called disjoint sets if they don’t have any element in common, the intersection of sets is a null set.

    // The disjoint Set data structure is generally used for dynamic graphs.

    // In the disjoint-set data structure, every element is part of just one set.
    // This structure lets us combine (union) two sets into one and figure out (find) which set a specific element belongs to.


    // Why we require Disjoint set?
    // If we want to check whether a specific node is in a component, we usually use BFS or DFS, which works but can be a bit brute-force.
    // With a disjoint set data structure, we can do it more efficiently and quickly in constant time.

    // TC using BDF/DFS - O(V + E)
    // TC using Disjoint Set - O(4α) (4 Alpha) = O(1)


    // Disjoint set data structure generally provides two types of functionalities:
    // 1. Find (Finding the parent for a particular node)
    // 2. Union (adding an edge between two nodes)
    //    i.  Union by rank
    //    ii. Union by size


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

    int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
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

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        ds.unionByRank(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
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
//        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }
//
//        ds.unionBySize(3, 7);
//        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
//            System.out.println("Same");
//        } else {
//            System.out.println("Not Same");
//        }

    }

}
