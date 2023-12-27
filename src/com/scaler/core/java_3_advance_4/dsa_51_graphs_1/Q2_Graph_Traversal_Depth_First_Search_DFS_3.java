package com.scaler.core.java_3_advance_4.dsa_51_graphs_1;

import java.util.*;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q2_Graph_Traversal_Depth_First_Search_DFS_3 {
    private int numVertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Q2_Graph_Traversal_Depth_First_Search_DFS_3(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // adjacencyList.get(destination).add(source); // For undirected graph
    }

    public void dfsTraversal() {
        Set<Integer> visited = new HashSet<>();
        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                dfsRecursive(vertex, visited);
            }
        }
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        Q2_Graph_Traversal_Depth_First_Search_DFS_3 graph =
                new Q2_Graph_Traversal_Depth_First_Search_DFS_3(numNodes);

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
