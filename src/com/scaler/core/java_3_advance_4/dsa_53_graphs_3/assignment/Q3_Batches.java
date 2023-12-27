package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 01/04/23 11:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Batches {
    List<List<Integer>> adjList;
    int count = 0;

    public int solve(int A, int[] B, int[][] C, int D) {
        boolean[] visited = new boolean[A + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < C.length; i++) {
            adjList.get(C[i][0]).add(C[i][1]);
            adjList.get(C[i][1]).add(C[i][0]);
        }
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                bfs(i, visited, B, D);
            }
        }
        return count;
    }

    private void bfs(int node, boolean[] visited, int[] B, int D) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        int currentStrength = 0;
        q.add(node);
        while (!q.isEmpty()) {
            int temp = q.poll();
            currentStrength += B[temp - 1];
            for (int neighbor : adjList.get(temp)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        if (currentStrength >= D)
            count++;
    }
}
