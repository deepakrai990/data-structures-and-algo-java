package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_2 {
    private List<List<Integer>> adjacencyList;
    private int numVertices;

    public Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        // For an undirected graph, add the destination to the source's list and vice versa
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void displayAdjacencyList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage
        int numNodes = 5;  // Adjust as needed
        Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_2 graph =
                new Q1_Graph_Representation_using_Adjacency_List_in_Java_undirected_2(numNodes);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Displaying the adjacency list
        graph.displayAdjacencyList();
    }
}
