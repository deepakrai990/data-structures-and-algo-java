package com.scaler.core.java_3_advance_4.dsa_55_graphs_5;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q2_Bellman_Ford_Algorithm {
    /**
     * Problem: Bellman Ford Algorithms
     * How to find the shortest path to all nodes from a single source, if positive weights are present.
     * **/
    private static final int MAX = Integer.MAX_VALUE;
    public static void bellmanFord(int[][] graph, int source) {
        int vertices = graph.length;
        // Initialize distances array
        int[] distance = new int[vertices];
        Arrays.fill(distance, MAX);
        distance[source] = 0;
        // Relax edges for V-1 iterations
        for (int iteration = 1; iteration < vertices; iteration++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    int weight = graph[u][v];
                    if (weight != MAX && distance[u] != MAX && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }
                }
            }
        }
        // Detect negative cycles (optional)
        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                int weight = graph[u][v];
                if (weight != MAX && distance[u] != MAX && distance[u] + weight < distance[v]) {
                    System.out.println("Graph contains a negative cycle");
                    return;
                }
            }
        }
        // Print the results
        System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
        for (int i = 0; i < vertices; i++) {
            if (i != source) {
                System.out.println("Vertex " + i + ": " + distance[i]);
            }
        }
    }
    public static void main(String[] args) {
        // int vertices = 5; // Number of vertices in the graph

        // Example graph represented as an adjacency matrix with weights
        int[][] graph = {
                {0, -1, 4, MAX, MAX},
                {MAX, 0, 3, 2, 2},
                {MAX, MAX, 0, MAX, MAX},
                {MAX, 1, 5, 0, MAX},
                {MAX, MAX, MAX, -3, 0}
        };

        int sourceVertex = 0; // Source vertex for Bellman-Ford algorithm

        // Apply Bellman-Ford algorithm to find shortest paths
        bellmanFord(graph, sourceVertex);
    }
}
