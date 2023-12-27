package com.scaler.core.java_3_advance_4.dsa_54_graphs_4;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Commutable_Islands_Prims_algo_2_2 {
    /**
     * Problem: Prims Algorithms
     * Given N islands and cost of the construction of a bridge between multiple pair of islands.
     * Find minimum cost of construction required such that it is possible to travel
     * from one island to any other island via bridges.
     * If not possible, return -1
     * **/
    private static int minimumCost(int n, int[][] bridges) {
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
        // Start with the first island
        key[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int minKeyIndex = findMinKeyIndex(visited, key);
            visited[minKeyIndex] = true;
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[minKeyIndex][j] != Integer.MAX_VALUE && !visited[j]
                        && adjacencyMatrix[minKeyIndex][j] < key[j]) {
                    key[j] = adjacencyMatrix[minKeyIndex][j];
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
    private static int findMinKeyIndex(boolean[] visited, int[] key) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
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
