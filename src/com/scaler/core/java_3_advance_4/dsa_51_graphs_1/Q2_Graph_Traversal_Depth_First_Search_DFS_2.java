package com.scaler.core.java_3_advance_4.dsa_51_graphs_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q2_Graph_Traversal_Depth_First_Search_DFS_2 {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q2_Graph_Traversal_Depth_First_Search_DFS_2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public void dfsTraversal() {
        boolean[] visited = new boolean[numVertices];
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                dfsRecursive(vertex, visited);
            }
        }
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    public static void main(String[] args) {
        int numNodes = 5;
        Q2_Graph_Traversal_Depth_First_Search_DFS_2 graph =
                new Q2_Graph_Traversal_Depth_First_Search_DFS_2(numNodes);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Depth First Search Traversal:");
        graph.dfsTraversal();
    }
}
