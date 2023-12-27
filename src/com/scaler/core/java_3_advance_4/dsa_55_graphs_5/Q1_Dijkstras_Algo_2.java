package com.scaler.core.java_3_advance_4.dsa_55_graphs_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Dijkstras_Algo_2 {
    private static int[] dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        // Initialize distances array
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Priority queue to store vertices with their distances
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        // Start from the source vertex
        distance[source] = 0;
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            // Explore neighbors
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                int weight = graph[currentVertex][neighbor];
                // Update distance if a shorter path is found
                if (weight > 0 && distance[currentVertex] != Integer.MAX_VALUE
                        && distance[currentVertex] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[currentVertex] + weight;
                    pq.offer(new Node(neighbor, distance[neighbor]));
                }
            }
        }
        return distance;
    }

    static class Node {
        int vertex, distance;
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices in the graph

        // Example graph represented as an adjacency matrix with weights
        int[][] graph = {
                {0, 2, 0, 0, 1, 0},
                {2, 0, 4, 1, 0, 0},
                {0, 4, 0, 3, 0, 0},
                {0, 1, 3, 0, 0, 5},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0}
        };

        int sourceVertex = 0; // Source vertex for Dijkstra's algorithm

        // Find the shortest path from the source vertex to all other vertices
        int[] shortestDistances = dijkstra(graph, sourceVertex);

        // Print the results
        System.out.println("Shortest distances from vertex " + sourceVertex + " to all other vertices:");

        for (int i = 0; i < vertices; i++) {
            if (i != sourceVertex) {
                System.out.println("Vertex " + i + ": " + shortestDistances[i]);
            }
        }
    }
}
