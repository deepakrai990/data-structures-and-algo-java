package com.scaler.core.java_3_advance_4.dsa_54_graphs_4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q3_Min_Edges_To_Reach_Vertex {
    /**
     * Problem: Find the minimum number of edges to reach v starting from u.
     * All edges have the same weight.
     * **/
    public static int minEdges(int[][] graph, int u, int v) {
        int vertices = graph.length;
        // Check if u and v are valid vertices
        if (u < 0 || u >= vertices || v < 0 || v >= vertices) {
            return -1;
        }
        // Initialize visited array and distance array
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        // Initialize queue for BFS
        Queue<Integer> queue = new ArrayDeque<>();
        // Start BFS from vertex u
        queue.offer(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : graph[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[currentVertex] + 1;
                    queue.offer(neighbor);
                    // Check if we reached vertex v
                    if (neighbor == v) {
                        return distance[v];
                    }
                }
            }
        }
        // If v is not reachable from u
        return -1;
    }
    public static void main(String[] args) {
        // int vertices = 6;
        int[][] graph = {
                {1, 2},
                {0, 2, 3},
                {0, 1, 4},
                {1, 5},
                {2},
                {3}
        };
        int u = 0;
        int v = 5;
        int result = minEdges(graph, u, v);
        if (result != -1) {
            System.out.println("Minimum number of edges from " + u + " to " + v + ": " + result);
        } else {
            System.out.println("Vertex " + v + " is not reachable from " + u);
        }
    }
    /*
      0 -- 1 -- 2 -- 4
       \         /
        \       /
         3 -- 5
      **/
}
