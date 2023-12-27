package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q2_b_Topological_Sort_or_order_right_to_left {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q2_b_Topological_Sort_or_order_right_to_left(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private List<Integer> topologicalSortRightToLeft() {
        List<Integer> topologicalOrder = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        // Perform DFS and push vertices to the stack
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, visited, stack);
            }
        }
        // Pop vertices from the stack to get the topological order
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        int numVertices = 6;
        Q2_b_Topological_Sort_or_order_right_to_left graph =
                new Q2_b_Topological_Sort_or_order_right_to_left(numVertices);

        // Add edges to the graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalOrder = graph.topologicalSortRightToLeft();

        if (topologicalOrder.isEmpty()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("Topological Order (Left to Right): " + topologicalOrder);
        }
    }
}
