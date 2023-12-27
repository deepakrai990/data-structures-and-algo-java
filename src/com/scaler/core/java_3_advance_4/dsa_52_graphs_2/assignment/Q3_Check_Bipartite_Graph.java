package com.scaler.core.java_3_advance_4.dsa_52_graphs_2.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 02/04/23 8:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Check_Bipartite_Graph {
    List<List<Integer>> adj;
    int[] visited;

    public int solve(int A, int[][] B) {
        adj = new ArrayList<>();
        for (int i = 0; i < A; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }

        visited = new int[A];

        for (int i = 0; i < A; i++) {
            if (!bfs(i))
                return 0;
        }
        return 1;
    }

    private boolean bfs(int node) {
        if (visited[node] != 0)
            return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int color = 1;
        visited[node] = color;
        while (!q.isEmpty()) {
            int temp = q.poll();
            color = visited[temp] == 1 ? 2 : 1; // changing color
            for (int neighbor : adj.get(temp)) {
                if (visited[neighbor] == visited[temp]) {//if current node and neighbor node shares same color
                    return false;
                } else if (visited[neighbor] == 0) {
                    visited[neighbor] = color;
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
}
