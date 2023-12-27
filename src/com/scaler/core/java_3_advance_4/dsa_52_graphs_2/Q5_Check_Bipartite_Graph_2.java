package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q5_Check_Bipartite_Graph_2 {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q5_Check_Bipartite_Graph_2(int numVertices, List<List<Integer>> adjacencyList) {
        this.numVertices = numVertices;
        this.adjacencyList = adjacencyList;
    }
    private boolean isBipartite() {
        int[] colors = new int[numVertices];
        int[] othercolors = new int[numVertices];
        boolean bipartite = true;
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (colors[vertex] == 0) {
                // Uncolored vertex
                bipartite &= dfsColoring(vertex, 1, colors, othercolors);
            }
        }
        return bipartite;
    }

    private boolean dfsColoring(int currentVertex, int color, int[] colors, int[] othercolors) {
        colors[currentVertex] = color;
        othercolors[currentVertex] = 3 - color;  // Opposite color
        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (colors[neighbor] == color) {
                // Neighbor has the same color as the current vertex, not bipartite
                return false;
            }
            if (colors[neighbor] == 0) {
                // Neighbor is uncolored, recursively assign the opposite color
                if (!dfsColoring(neighbor, othercolors[currentVertex], colors, othercolors)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numVertices = 4;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges to the graph
        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);
        adjacencyList.get(0).add(3);
        adjacencyList.get(3).add(0);

        Q5_Check_Bipartite_Graph_2 bipartiteCheck = new Q5_Check_Bipartite_Graph_2(numVertices, adjacencyList);
        boolean isBipartite = bipartiteCheck.isBipartite();

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
