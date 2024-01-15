package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 01/04/23 11:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Another_BFS {
    static class Pair {
        Integer nodeVal;
        Integer weight;
        public Pair(Integer n, Integer w) {
            nodeVal = n;
            weight = w;
        }
    }

    private static int solve(int A, int[][] B, int C, int D) {
        if (C == D) return 0;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        int newNode = A;
        for (int i = 0; i < B.length; i++) {
            if (B[i][2] == 2) {
                adj.add(new ArrayList<>());

                adj.get(B[i][0]).add(new Pair(newNode, 1));
                adj.get(newNode).add(new Pair(B[i][0], 1));

                adj.get(newNode).add(new Pair(B[i][1], 1));
                adj.get(B[i][1]).add(new Pair(newNode, 1));
                newNode++;
            } else {
                adj.get(B[i][0]).add(new Pair(B[i][1], 1));
                adj.get(B[i][1]).add(new Pair(B[i][0], 1));
            }
        }

        boolean[] visited = new boolean[newNode + 1];
        Queue<Pair> q = new LinkedList<>();
        visited[C] = true;
        for (Pair neighbor : adj.get(C)) {
            q.add(neighbor);
            visited[neighbor.nodeVal] = true;
        }

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (temp.nodeVal == D)
                return temp.weight;
            for (Pair neighbor : adj.get(temp.nodeVal)) {
                if (!visited[neighbor.nodeVal]) {
                    visited[neighbor.nodeVal] = true;
                    if (neighbor.nodeVal == D)
                        return temp.weight + 1;
                    q.add(new Pair(neighbor.nodeVal, temp.weight + 1));
                    visited[neighbor.nodeVal] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1}};
        int C = 3;
        int D = 2;

        int result = solve(A, B, C, D);
        PrintUtils.print(result);
    }
}
