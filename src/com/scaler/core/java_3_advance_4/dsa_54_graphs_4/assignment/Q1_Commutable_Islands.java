package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Commutable_Islands {
     static class Pair {
        Integer nodeVal;
        Integer weight;
        public Pair(Integer n, Integer w) {
            nodeVal = n;
            weight = w;
        }
    }

    private static int solve(int A, int[][] B) {
        List<List<Pair>> adj = new ArrayList<>();
        boolean[] visited = new boolean[A + 1];
        for (int i = 0; i <= A; i++)
            adj.add(new ArrayList<>());


        for (int i = 0; i < B.length; i++) {
            adj.get(B[i][0]).add(new Pair(B[i][1], B[i][2]));
            adj.get(B[i][1]).add(new Pair(B[i][0], B[i][2]));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        visited[1] = true;
        int minCost = 0;
        for (Pair neighbor : adj.get(1)) {
            minHeap.add(neighbor);
        }

        while (!minHeap.isEmpty()) {
            Pair temp = minHeap.poll();
            if (!visited[temp.nodeVal]) {
                visited[temp.nodeVal] = true;
                minCost += temp.weight;
                for (Pair neighbor : adj.get(temp.nodeVal)) {
                    if (!visited[neighbor.nodeVal]) {
                        minHeap.add(neighbor);
                    }
                }
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10},};

        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
