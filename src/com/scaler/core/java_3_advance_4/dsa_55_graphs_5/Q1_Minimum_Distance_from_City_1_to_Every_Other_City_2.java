package com.scaler.core.java_3_advance_4.dsa_55_graphs_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Minimum_Distance_from_City_1_to_Every_Other_City_2 {
    /**
     * Problem: Dijkstra's Algorithms
     * There are N cities in a country, you are living in city 1.
     * Find minimum distance to react every other city from city 1.
     * **/
    private static int[] minDistances(int[][] graph, int source) {
        int N = graph.length;
        // Initialize distances array
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Priority queue to store vertices with their distances
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        // Start from the source city
        distance[source] = 0;
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            // Explore neighbors
            for (int neighbor = 0; neighbor < N; neighbor++) {
                int weight = graph[currentCity][neighbor];
                // Update distance if a shorter path is found
                if (weight > 0 && distance[currentCity] != Integer.MAX_VALUE
                        && distance[currentCity] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[currentCity] + weight;
                    pq.offer(new Node(neighbor, distance[neighbor]));
                }
            }
        }
        return distance;
    }
    static class Node {
        int city, distance;

        public Node(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        int N = 6; // Number of cities
        int[][] graph = {
                {0, 2, 0, 0, 1, 0},
                {2, 0, 4, 1, 0, 0},
                {0, 4, 0, 3, 0, 0},
                {0, 1, 3, 0, 0, 5},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0}
        };

        int sourceCity = 0; // You are living in city 1 (0-indexed)

        int[] distances = minDistances(graph, sourceCity);

        System.out.println("Minimum distances from city " + (sourceCity + 1) + " to every other city:");

        for (int i = 0; i < N; i++) {
            if (i != sourceCity) {
                System.out.println("City " + (i + 1) + ": " + distances[i]);
            }
        }
    }
}
