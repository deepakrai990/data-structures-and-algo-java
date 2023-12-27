package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.directed;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_2 {
    static class Graph {
        private int vertices; // Number of nodes
        private int[][] adjacencyMatrix;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyMatrix = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination) {
            adjacencyMatrix[source][destination] = 1;
            // adjacencyMatrix[destination][source] = 1; // For undirected graph
        }

        public int[][] getAdjacencyMatrix() {
            return adjacencyMatrix;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);


        int[][] matrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < graph.vertices; i++) {
            for (int j = 0; j < graph.vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
