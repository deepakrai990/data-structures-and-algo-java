package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q4_Graph_Coloring_1 {
    private int numVertices;
    private int[][] adjacencyMatrix;

    public Q4_Graph_Coloring_1(int numVertices, int[][] adjacencyMatrix) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    private int minimizeColors() {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1); // Initialize all vertices as uncolored
        for (int vertex = 0; vertex < numVertices; vertex++) {
            Set<Integer> availableColors = getAvailableColors(vertex, colors);
            // Assign the lowest available color to the current vertex
            while (availableColors.iterator().hasNext()) {
                int chosenColor = availableColors.iterator().next();
                colors[vertex] = chosenColor;
            }
        }
        // Count distinct colors
        Set<Integer> distinctColors = new HashSet<>();
        for (int color : colors) {
            distinctColors.add(color);
        }
        return distinctColors.size();
    }
    private Set<Integer> getAvailableColors(int vertex, int[] colors) {
        Set<Integer> availableColors = new HashSet<>();
        for (int neighbor = 0; neighbor < numVertices; neighbor++) {
            if (adjacencyMatrix[vertex][neighbor] == 1 && colors[neighbor] != -1) {
                availableColors.add(colors[neighbor]);
            }
        }
        return availableColors;
    }

    public static void main(String[] args) {
        int numVertices = 4;
        int[][] adjacencyMatrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        Q4_Graph_Coloring_1 graphColoring = new Q4_Graph_Coloring_1(numVertices, adjacencyMatrix);

        int distinctColors = graphColoring.minimizeColors();

        System.out.println("The minimum number of distinct colors needed: " + distinctColors);
    }
}
