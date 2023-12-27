package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Possibility_of_Finishing {
    public int solve(int A, int[] B, int[] C) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i]).add(C[i]);
        }
        int[] inDegree = new int[A + 1];
        //fill inDegree
        for (int i = 1; i <= A; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        //creating minHeap and insert all the nodes in minHeap which have inDegree is equal to zero
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) minHeap.add(i);
        }

        while (!minHeap.isEmpty()) {
            int temp = minHeap.poll();
            for (int neighbor : adjList.get(temp)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    minHeap.add(neighbor);
                }
            }
        }

        //if there is a cycle existed the inDegree of all nodes can’t be 0
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] > 0 || inDegree[i] < 0)
                return 0;
        }
        return 1;
    }
}
