package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Cycle_in_a_directed_graph_1 {
    /**
     * Problem: Check if a simple directed graph has a cycle.
     * **/
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q1_Cycle_in_a_directed_graph_1(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }
    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] inStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, inStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] inStack) {
        visited[vertex] = true;
        inStack[vertex] = true;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, inStack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        inStack[vertex] = false; // Backtrack
        return false;
    }
    public static void main(String[] args) {
        int numNodes = 4;
        Q1_Cycle_in_a_directed_graph_1 graph = new Q1_Cycle_in_a_directed_graph_1(numNodes);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        if (graph.hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
}
