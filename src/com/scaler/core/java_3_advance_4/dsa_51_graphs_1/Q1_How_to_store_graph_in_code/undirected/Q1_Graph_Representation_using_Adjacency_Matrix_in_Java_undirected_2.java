package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.undirected;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_2 {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        // For an undirected graph, set both entries to 1
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void displayAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage
        int numNodes = 5;  // Adjust as needed
        Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_2 graph =
                new Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_2(numNodes);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        // Displaying the adjacency matrix
        graph.displayAdjacencyMatrix();
    }
}
