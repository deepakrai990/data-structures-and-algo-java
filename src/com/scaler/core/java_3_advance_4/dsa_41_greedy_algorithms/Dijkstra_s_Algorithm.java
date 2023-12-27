package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */
public class Dijkstra_s_Algorithm {
    static class Edge implements Comparable<Edge> {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    /**
     * Dijkstra's algorithm is a popular algorithm for finding the shortest
     * paths between nodes in a graph. Here's a simple Java implementation of Dijkstra's algorithm:
     * In this example, the graph is represented as an adjacency list. The Edge class is used to
     * represent edges with their destinations and weights. The dijkstra function calculates
     * the shortest distances from the start vertex to all other vertices in the graph.
     * The result is then printed to the console.
     * **/
    private static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int start) {
        int vertices = graph.size();
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        distance[start] = 0;
        minHeap.add(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            int currentVertex = current.destination;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = distance[currentVertex] + neighbor.weight;
                if (newDistance < distance[neighbor.destination]) {
                    distance[neighbor.destination] = newDistance;
                    minHeap.add(new Edge(neighbor.destination, newDistance));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(4, 1));
        graph.get(3).add(new Edge(5, 5));
        graph.get(4).add(new Edge(5, 2));

        int startVertex = 0;
        int[] shortestDistances = dijkstra(graph, startVertex);

        // Print the shortest distances
        System.out.println("Shortest Distances from vertex " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + ": " + shortestDistances[i]);
        }
    }
}
