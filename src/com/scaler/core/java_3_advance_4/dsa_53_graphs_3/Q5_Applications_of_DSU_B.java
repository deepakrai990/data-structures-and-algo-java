package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q5_Applications_of_DSU_B {
    private int[] parent;
    private int[] rank;
    // Constructor to initialize DSU
    public Q5_Applications_of_DSU_B(int size) {
        parent = new int[size];
        rank = new int[size];
        // Initialize each element as its own parent
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    // Union operation to merge two sets
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // Attach the smaller rank tree under the root of the higher rank tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            // If ranks are the same, make one as the root and increment its rank
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
    // Find operation to determine the representative of the set with path compression
    public int find(int x) {
        // Path compression: Make each node point directly to the root
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // Function to detect cycles in an undirected graph using DSU
    private static boolean hasCycle(int[][] edges, Q5_Applications_of_DSU_B dsu) {
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int rootX = dsu.find(x);
            int rootY = dsu.find(y);
            // If the roots are the same, there is a cycle
            if (rootX == rootY) {
                return true;
            }
            // Otherwise, union the sets
            dsu.union(x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        int numVertices = 6;
        Q5_Applications_of_DSU_B dsu = new Q5_Applications_of_DSU_B(numVertices);

        // Edges in the graph
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 0}, {2, 5}}; // has cycle
        // int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {4, 5}}; // has no cycle or acyclic

        // Detect cycles in the graph
        if (hasCycle(edges, dsu)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph has no cycle.");
            System.out.println("The graph is acyclic.");
        }
    }
}
