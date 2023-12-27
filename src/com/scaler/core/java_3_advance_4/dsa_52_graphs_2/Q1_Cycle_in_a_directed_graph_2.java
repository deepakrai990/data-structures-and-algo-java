package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q1_Cycle_in_a_directed_graph_2 {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q1_Cycle_in_a_directed_graph_2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    private void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private boolean hasCycle() {
        boolean[] vis = new boolean[numVertices];
        boolean[] path = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!vis[i] && dfs(i, vis, path)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int s, boolean[] vis, boolean[] path) {
        vis[s] = true;
        path[s] = true;

        for (int v : adjacencyList.get(s)) {
            if (!vis[v]) {
                if (dfs(v, vis, path)) {
                    return true;
                }
            } else if (path[v]) {
                return true; // Cycle detected
            }
        }

        path[s] = false; // Backtrack
        return false;
    }
    public static void main(String[] args) {
        int numNodes = 4;
        Q1_Cycle_in_a_directed_graph_2 graph = new Q1_Cycle_in_a_directed_graph_2(numNodes);

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
