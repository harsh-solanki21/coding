package Graphs;

public class DisjointSet {

    public int[] parent;
    public int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node]); // Path compression
        return parent[node];
    }

    public void unionBySize(int i, int j) {
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
    }

}
