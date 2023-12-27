package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q4_Applications_of_DSU_A {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize DSU
    public Q4_Applications_of_DSU_A(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initialize each element as its own parent
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Union operation to merge two sets
    private void union(int x, int y) {
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
    private int find(int x) {
        // Path compression: Make each node point directly to the root
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private static boolean isConnected(int[][] edges, Q4_Applications_of_DSU_A dsu) {
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            // Union the sets
            dsu.union(x, y);
        }

        // Check if there is only one representative set (root)
        int root = dsu.find(0);
        for (int i = 1; i < dsu.parent.length; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int numVertices = 6;
        Q4_Applications_of_DSU_A dsu = new Q4_Applications_of_DSU_A(numVertices);
        // Edges in the connected graph
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 0}, {2, 5}}; // has cycle
        // int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {4, 5}}; // has no cycle, or it is acyclic

        // Check if the graph is connected
        if (isConnected(edges, dsu)) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
    }
}
