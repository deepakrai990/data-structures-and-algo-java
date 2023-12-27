package com.scaler.core.java_3_advance_4.dsa_51_graphs_1;

import java.util.*;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q3_Graph_Traversal_Breadth_First_Search_Search_BFS_2 {
    private int numVertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Q3_Graph_Traversal_Breadth_First_Search_Search_BFS_2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // adjacencyList.get(destination).add(source); // For undirected graph
    }

    public void bfsTraversal(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        Q3_Graph_Traversal_Breadth_First_Search_Search_BFS_2 graph = new Q3_Graph_Traversal_Breadth_First_Search_Search_BFS_2(numNodes);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Breadth First Search Traversal starting from node 0:");
        graph.bfsTraversal(0);
    }
}
