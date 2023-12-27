package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_List_in_Java_3 {
    static class Graph {
        private int vertices;
        private List<Integer>[] adjacencyList;
        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < this.vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }
        public List<Integer> getNeighbors(int node) {
            return adjacencyList[node];
        }
        public List<Integer>[] getAdjacencyList() {
            return adjacencyList;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        // Access neighbors of a vertex
        List<Integer> neighbors = graph.getNeighbors(1);
        System.out.println("Neighbors of vertex 1: " + neighbors);
        List<Integer>[] adjacencyList = graph.getAdjacencyList();
        System.out.print("{");
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(i + "=");
            List<Integer> list = adjacencyList[i];
            if (list.isEmpty()) {
                System.out.print("[]");
            } else {
                System.out.print(list);
            }
            if (i < adjacencyList.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }
}
