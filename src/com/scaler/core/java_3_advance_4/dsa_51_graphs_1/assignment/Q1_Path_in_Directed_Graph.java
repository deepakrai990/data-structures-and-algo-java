package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 02/04/23 8:31 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Path_in_Directed_Graph {

    public int solve(int A, int[][] B) {
        List<List<Integer>> adjacenyList = new ArrayList<>(); //not linked-list needs to search in O(1)
        int n = B.length;
        //total number of nodes
        for (int i = 0; i <= A; i++) {
            adjacenyList.add(new ArrayList<>());
        }
        //creating adj list
        for (int i = 0; i < n; i++) {
            adjacenyList.get(B[i][0]).add(B[i][1]);
        }

        boolean[] visited = new boolean[A + 1];

        //level order traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int node : adjacenyList.get(current)) {
                if (!visited[node]) {
                    if (node == A)
                        return 1;
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
        return 0;
    }
}
