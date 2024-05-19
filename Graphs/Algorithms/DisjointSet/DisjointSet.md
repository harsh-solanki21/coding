# Disjoint Set (Union-Find Algorithm)

- Two sets are called disjoint sets if they don’t have any element in common, the intersection of sets is a null set.

- The disjoint Set data structure is generally used for dynamic graphs.


- In the disjoint-set data structure, every element is part of just one set.
- This structure lets us combine (union) two sets into one and figure out (find) which set a specific element belongs to.


### Why we require Disjoint set?
- If we want to check whether a specific node is in a component, we usually use BFS or DFS, which works but can be a bit brute-force.
- With a disjoint set data structure, we can do it more efficiently and quickly in constant time.


### Disjoint set data structure generally provides two functionalities:
1. Find (Finding the parent for a particular node)
2. Union (adding an edge between two nodes)
   1. Union by rank
   2. Union by size

<br />

### Path Compression Optimization:
```
int find(int n) {
   if (parent[n] == n) {
      return n;
   }
   parent[n] = find(parent[n]);  // Path Compression
   return parent[n];
}
```
- The result of `find(parent[n])` is assigned back to `parent[n]`. This step is called `path compression`. Path compression is an optimization that `flattens` the structure of the tree whenever `find` is called. By making every node on the path point directly to the root, it speeds up future operations by reducing the tree's height.


<br />

### Time and Space Complexity
**Naive Approach:** TC - O(n), SC - O(n)

**Path Compression:** TC - O(log n), SC - O(n)

**Combination of both optimizations (path compression with union by size / rank):** TC - O(α(n)) / O(4α) = O(1)

- The final `amortized` time complexity is O(α(n)), where α(alpha) is `Inverse Ackermann Function`, which grows very slowly.

- `Amortized complexity` is the total time per operation, evaluated over a sequence of multiple operations.

- The idea is to guarantee the total time of the entire sequence, while allowing single operations to be much slower than the amortized time. E.g. in our case a single call might take O(log n) in the worst case, but if we do m such calls back to back we will end up with an `average time of O(α(n))`.
