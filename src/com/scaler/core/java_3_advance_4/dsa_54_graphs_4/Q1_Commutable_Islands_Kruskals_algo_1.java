package com.scaler.core.java_3_advance_4.dsa_54_graphs_4;

import java.util.Arrays;

/**
 * @created 01/04/23 11:41 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Commutable_Islands_Kruskals_algo_1 {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }
    private int[] parent;
    private int[] rank;

    public Q1_Commutable_Islands_Kruskals_algo_1(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }

    /**
     * Problem: Kruskal's Algorithms
     * Given N islands and cost of the construction of a bridge between multiple pair of islands.
     * Find minimum cost of construction required such that it is possible to travel
     * from one island to any other island via bridges.
     * If not possible, return -1
     * **/

    private static int minimumCost(int n, int[][] bridges) {
        Edge[] edges = new Edge[bridges.length];
        for (int i = 0; i < bridges.length; i++) {
            edges[i] = new Edge(bridges[i][0], bridges[i][1], bridges[i][2]);
        }
        Arrays.sort(edges);
        Q1_Commutable_Islands_Kruskals_algo_1 dsu = new Q1_Commutable_Islands_Kruskals_algo_1(n);
        int totalCost = 0;
        int edgeCount = 0;
        for (Edge edge : edges) {
            if (edgeCount == n - 1) {
                break; // All islands are connected
            }
            int rootSource = dsu.find(edge.source);
            int rootDest = dsu.find(edge.destination);
            if (rootSource != rootDest) {
                dsu.union(rootSource, rootDest);
                totalCost += edge.weight;
                edgeCount++;
            }
        }
        if (edgeCount == n - 1) {
            return totalCost;
        } else {
            return -1; // It is not possible to connect all islands
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] bridges = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };
        int result = minimumCost(n, bridges);

        if (result != -1) {
            System.out.println("Minimum cost to connect all islands: " + result);
        } else {
            System.out.println("It is not possible to connect all islands.");
        }
    }
}
