package com.scaler.core.java_3_advance_4.dsa_54_graphs_4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Commutable_Islands_Prims_algo_2_1 {
    /**
     * Problem: Prims Algorithms
     * Given N islands and cost of the construction of a bridge between multiple pair of islands.
     * Find minimum cost of construction required such that it is possible to travel
     * from one island to any other island via bridges.
     * If not possible, return -1
     * **/
    public static int minimumCost(int n, int[][] bridges) {
        int[][] adjacencyMatrix = new int[n][n];
        // Initialize the adjacency matrix
        for (int[] row : adjacencyMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Fill the adjacency matrix with bridge costs
        for (int[] bridge : bridges) {
            int source = bridge[0];
            int destination = bridge[1];
            int cost = bridge[2];
            adjacencyMatrix[source][destination] = cost;
            adjacencyMatrix[destination][source] = cost;
        }
        boolean[] visited = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);

        // Using a min-heap to efficiently select the minimum edge
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        minHeap.offer(new Edge(0, 0)); // Start with the first island

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentVertex = currentEdge.vertex;
            int currentKey = currentEdge.key;
            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;
            key[currentVertex] = currentKey;
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (!visited[neighbor] && adjacencyMatrix[currentVertex][neighbor] != Integer.MAX_VALUE) {
                    minHeap.offer(new Edge(neighbor, adjacencyMatrix[currentVertex][neighbor]));
                }
            }
        }
        int totalCost = 0;
        for (int k : key) {
            if (k == Integer.MAX_VALUE) {
                return -1; // It is not possible to connect all islands
            }
            totalCost += k;
        }
        return totalCost;
    }

    static class Edge implements Comparable<Edge> {
        int vertex, key;
        public Edge(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.key, other.key);
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
