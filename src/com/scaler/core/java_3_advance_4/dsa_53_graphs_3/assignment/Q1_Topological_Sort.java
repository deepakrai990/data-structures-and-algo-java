package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 01/04/23 11:55 pm
 * @project scaler_course_code
 */
public class Q1_Topological_Sort {
    private static int[] solve(int A, int[][] B) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).add(B[i][1]);
        }
        int[] inDegree = new int[A + 1];
        //fill in degree
        for (int i = 1; i <= A; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        int[] ans = new int[A];

        //creating minHeap and insert all the nodes in minHeap which have in degree is equal to zero
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) minHeap.add(i);
        }

        int index = 0;
        while (!minHeap.isEmpty()) {
            int temp = minHeap.poll();
            ans[index++] = temp;
            for (int neighbor : adjList.get(temp)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    minHeap.add(neighbor);
                }
            }
        }
        //if there is a cycle existed, the in degree of all nodes can’t be 0
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] > 0 || inDegree[i] < 0)
                return new int[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2},};

        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
