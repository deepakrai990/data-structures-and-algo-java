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
public class Q4_Construct_Roads {
    int[] visited;
    List<List<Integer>> adjList;
    int mod = 1000000007;

    public int solve(int A, int[][] B) {
        visited = new int[A + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).add(B[i][1]);
            adjList.get(B[i][1]).add(B[i][0]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0)
                bfs(i);
        }
        long a = 0;
        long b = 0;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 1)
                a++;
            else
                b++;
        }
        return (int) ((a * b) % mod - B.length) % mod;
    }

    private void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int color = 1;
        visited[node] = color;
        while (!q.isEmpty()) {
            int temp = q.poll();
            color = visited[temp] == 1 ? 2 : 1;
            for (int neighbor : adjList.get(temp)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = color;
                    q.add(neighbor);
                }
            }
        }
    }
}
