package com.scaler.core.java_3_advance_4.dsa_55_graphs_5;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q3_Floyd_Warshall_Algorithm {
    /**
     * Problem: Floyd Warshall's Algorithms
     * Find the shortest distance from every node to every node
     * **/
    private static final int MAX_INT = Integer.MAX_VALUE;
    private static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        // Initialize distances matrix
        int[][] distances = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distances[i][j] = graph[i][j];
            }
        }
        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    // If the path from i to j through k is shorter, update distance
                    if (distances[i][k] != MAX_INT &&
                            distances[k][j] != MAX_INT &&
                            distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        // Print the shortest paths
        System.out.println("Shortest paths between all pairs of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (distances[i][j] == MAX_INT) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distances[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int vertices = 4; // Number of vertices in the graph
        // Example graph represented as an adjacency matrix with weights
        int[][] graph = {
                {0, 3, MAX_INT, 5},
                {2, 0, MAX_INT, 4},
                {MAX_INT, 1, 0, MAX_INT},
                {MAX_INT, MAX_INT, 2, 0}
        };
        // Apply Floyd-Warshall algorithm to find the shortest paths
        floydWarshall(graph);
    }
}
