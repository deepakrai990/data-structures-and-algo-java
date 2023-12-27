package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */

public class Prim_s_Algorithm {
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
     * Prim's and Kruskal's algorithms are two different algorithms used for finding
     * the Minimum Spanning Tree (MST) of a connected, undirected graph.
     * Here are simple Java implementations for both algorithms:
     * **/
    private static ArrayList<ArrayList<Edge>> primMST(ArrayList<ArrayList<Edge>> graph, int start) {
        int vertices = graph.size();
        ArrayList<ArrayList<Edge>> mst = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            mst.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();

        visited[start] = true;
        minHeap.addAll(graph.get(start));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int destination = edge.destination;

            if (!visited[destination]) {
                visited[destination] = true;
                mst.get(start).add(edge);
                mst.get(destination).add(new Edge(start, edge.weight));

                for (Edge adjacentEdge : graph.get(destination)) {
                    if (!visited[adjacentEdge.destination]) {
                        minHeap.add(adjacentEdge);
                    }
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(2).add(new Edge(1, 3));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(3).add(new Edge(2, 3));

        int startVertex = 0;
        ArrayList<ArrayList<Edge>> mst = primMST(graph, startVertex);

        // Print the Minimum-Spanning Tree
        for (int i = 0; i < mst.size(); i++) {
            for (Edge edge : mst.get(i)) {
                System.out.println("Edge: " + i + " - " + edge.destination + ", Weight: " + edge.weight);
            }
        }
    }
}
