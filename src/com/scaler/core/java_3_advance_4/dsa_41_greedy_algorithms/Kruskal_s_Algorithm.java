package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */
public class Kruskal_s_Algorithm {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    /**
     * Kruskal's algorithm is used to find the minimum spanning tree (MST) in a connected,
     * undirected graph. Here's a simple Java implementation of Kruskal's algorithm:
     * <p>
     * In this example, the Edge class is used to represent edges with their source,
     * destination, and weight.
     * The Kruskal's Algorithm class performs Kruskal's algorithm on the provided graph
     * to find the minimum spanning tree (MST). The addEdge method is used to add edges
     * to the graph, and the kruskalMST method prints the edges of the MST.
     * **/
    private static ArrayList<Edge> kruskalMST(ArrayList<Edge> edges, int vertices) {
        ArrayList<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            if (rootSource != rootDestination) {
                mst.add(edge);
                union(parent, rootSource, rootDestination);
            }
        }

        return mst;
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge> edges = new ArrayList<>();

        // Add edges to the graph
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        ArrayList<Edge> mst = kruskalMST(edges, vertices);

        // Print the Minimum-Spanning Tree
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + ", Weight: " + edge.weight);
        }
    }

}
