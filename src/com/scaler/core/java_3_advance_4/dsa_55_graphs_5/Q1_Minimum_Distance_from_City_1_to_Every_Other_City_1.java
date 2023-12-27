package com.scaler.core.java_3_advance_4.dsa_55_graphs_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Minimum_Distance_from_City_1_to_Every_Other_City_1 {
    private static int[] dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        // Initialize distances array
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // MinHeap to store vertices with their distances
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        // Start from the source vertex
        distance[source] = 0;
        minHeap.offer(new Pair(source, 0));
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int currentVertex = current.vertex;
            // Explore neighbors
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                int weight = graph[currentVertex][neighbor];
                // Update distance if a shorter path is found
                if (weight > 0 && distance[currentVertex] != Integer.MAX_VALUE
                        && distance[currentVertex] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[currentVertex] + weight;
                    minHeap.offer(new Pair(neighbor, distance[neighbor]));
                }
            }
        }
        return distance;
    }

    static class Pair {
        int vertex, distance;
        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of cities
        // Example graph represented as an adjacency matrix with weights
        int[][] graph = {
                {0, 2, 0, 0, 1, 0},
                {2, 0, 4, 1, 0, 0},
                {0, 4, 0, 3, 0, 0},
                {0, 1, 3, 0, 0, 5},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0}
        };
        int sourceCity = 0; // You are living in city 1 (0-indexed)
        // Find the shortest path from the source city to all other cities
        int[] shortestDistances = dijkstra(graph, sourceCity);
        // Print the results
        System.out.println("Shortest distances from city " + (sourceCity + 1) + " to every other city:");

        for (int i = 0; i < vertices; i++) {
            if (i != sourceCity) {
                System.out.println("City " + (i + 1) + ": " + shortestDistances[i]);
            }
        }
    }
}
