package com.scaler.core.java_3_advance_4.dsa_54_graphs_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q4_Min_Weight_Travel {
    /**
     * Problem: Find the minimum weight to travel from u to v in given connected simple graph.
     * Need to work
     * **/
    public static int minWeight(int[][] graph, int u, int v) {
        int vertices = graph.length;
        // Check if u and v are valid vertices
        if (u < 0 || u >= vertices || v < 0 || v >= vertices) {
            return -1;
        }
        // Initialize distances array
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Priority queue to store vertices with their distances
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        // Start from vertex u
        distance[u] = 0;
        pq.offer(new Node(u, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            // Explore neighbors
            for (int neighbor : graph[currentVertex]) {
                int weight = graph[currentVertex][neighbor];
                int newDistance = distance[currentVertex] + weight;
                // Update distance if a shorter path is found
                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    pq.offer(new Node(neighbor, newDistance));
                }
            }
        }
        return distance[v] == Integer.MAX_VALUE ? -1 : distance[v];
    }

    static class Node {
        int vertex, distance;
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        // int vertices = 6;
        int[][] graph = {
                {0, 2, 0, 0, 1, 0},
                {2, 0, 4, 1, 0, 0},
                {0, 4, 0, 3, 0, 0},
                {0, 1, 3, 0, 0, 5},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0}
        };
        int u = 0;
        int v = 5;
        int result = minWeight(graph, u, v);

        if (result != -1) {
            System.out.println("Minimum weight to travel from " + u + " to " + v + ": " + result);
        } else {
            System.out.println("There is no path from " + u + " to " + v);
        }
    }
}
