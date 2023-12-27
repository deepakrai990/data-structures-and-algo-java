package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q2_a_Topological_Sort_or_order_left_to_right {
    /**
     * Problem: Topological Sort/order
     * It a linear ordering of nodes such that if there
     * is an edge from node i to node j is on the side of j (i.e., i < j)
     * **/
    private int numVertices;
    private List<List<Integer>> adjacencyList;
    private int[] inDegree;

    public Q2_a_Topological_Sort_or_order_left_to_right(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();
        this.inDegree = new int[numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        inDegree[destination]++;
    }

    public List<Integer> topologicalSortLeftToRight() {
        List<Integer> topologicalOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // Add vertices with in-degree 0 to the queue
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // Perform topological sorting using the queue
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topologicalOrder.add(currentVertex);
            for (int neighbor : adjacencyList.get(currentVertex)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add to the queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // Check if all vertices are visited (acyclic graph)
        if (topologicalOrder.size() != numVertices) {
            // Graph has a cycle
            return new ArrayList<>();
        }
        return topologicalOrder;
    }
    public static void main(String[] args) {
        int numVertices = 6;
        Q2_a_Topological_Sort_or_order_left_to_right graph =
                new Q2_a_Topological_Sort_or_order_left_to_right(numVertices);

        // Add edges to the graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalOrder = graph.topologicalSortLeftToRight();

        if (topologicalOrder.isEmpty()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("Topological Order: " + topologicalOrder);
        }
    }
}
