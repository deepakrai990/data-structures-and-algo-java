package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_3 {
    private Map<Integer, List<Integer>> adjacencyList;
    private int numVertices;

    public Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_3(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        // For an undirected graph, add the destination to the source's list and vice versa
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    private void displayAdjacencyList() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int node = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            System.out.print("Node " + node + " is connected to: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    private Map<Integer, List<Integer>> getAdjacencyList() {
        return this.adjacencyList;
    }

    public static void main(String[] args) {
        // Example usage
        int numNodes = 5;  // Adjust as needed
        Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_3 graph =
                new Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_3(numNodes);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        // Displaying the adjacency list
        graph.displayAdjacencyList();
        System.out.println();
        Map<Integer, List<Integer>> results = graph.getAdjacencyList();
        System.out.println(results);
    }
}
