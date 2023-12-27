package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q3_Disjoint_Set_Union_2 {
    private int[] parent;
    private int[] rank;
    // Constructor to initialize DSU
    public Q3_Disjoint_Set_Union_2(int size) {
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

    // Find operation to determine the representative of the set
    private int find(int x) {
        // Path compression: Make each node point directly to the root
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Example usage: Detecting cycles in an undirected graph
    private boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int rootX = find(x);
            int rootY = find(y);
            // If the roots are the same, there is a cycle
            if (rootX == rootY) {
                return true;
            }
            // Otherwise, union the sets
            union(x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 5;
        Q3_Disjoint_Set_Union_2 dsu = new Q3_Disjoint_Set_Union_2(size);

        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};

        if (dsu.hasCycle(edges)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph is acyclic.");
        }
    }
}
