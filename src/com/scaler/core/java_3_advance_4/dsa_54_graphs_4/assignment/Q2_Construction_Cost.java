package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.assignment;

import java.util.*;

/**
 * @created 01/04/23 11:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Construction_Cost {
    class Pair {
        int node;
        int weight;

        Pair(int N, int W) {
            this.node = N;
            this.weight = W;
        }
    }

    public int solve(int A, int[][] B) {
        ArrayList<Pair>[] graph = new ArrayList[A + 1];
        int i, j;
        int mod = 1000000007;
        int row = B.length;

        if (row == 0) {
            return 0;
        }

        int col = B[0].length;
        for (i = 0; i <= A; i++) {
            graph[i] = new ArrayList<Pair>();
        }
        // Add All Options in Adjancancy List from Matrix
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                // Undirected Graph so Add like
                // graph[u][v] and
                // graph[v][u]
                graph[B[i][0]].add(new Pair(B[i][1], B[i][2]));
                graph[B[i][1]].add(new Pair(B[i][0], B[i][2]));
            }
        }
        boolean[] visited = new boolean[A + 1];
        visited[1] = true;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.weight - p2.weight;
            }
        });

        // Add first Pair in min minHeap
        for (Pair p : graph[1]) {
            minHeap.add(p);
        }
        int minCost = 0;

        while (!minHeap.isEmpty()) {
            Pair top = minHeap.poll();
            if (!visited[top.node]) {
                minCost += top.weight;
                visited[top.node] = true;
                minCost %= mod;
            }

            for (Pair p : graph[top.node]) {
                if (!visited[p.node]) {
                    minHeap.add(p);
                }
            }
        }
        return minCost;
    }
}
