package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 02/04/23 8:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Cycle_in_Directed_Graph {
    List<List<Integer>> adjList;

    public int solve(int A, int[][] B) {
        adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        //creating adjList
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).add(B[i][1]);
        }

        //now the intuition is for every node I will perform dfs with a fresh visited array and if in that cycle I came to a visited node
        //which means I am in a cycle I will return true
        for (int i = 1; i <= A; i++) {
            boolean visited[] = new boolean[A + 1]; //important
            if (isCycle(i, visited))
                return 1;
        }
        return 0;
    }

    public boolean isCycle(int node, boolean[] visited) {
        // base case = visiting a already visited node
        if (visited[node])
            return true;

        visited[node] = true;
        boolean flag = false;
        for (int neighborNode : adjList.get(node)) {
            flag = isCycle(neighborNode, visited);
            if (flag)
                return true;
            //backtracking
            visited[neighborNode] = false;
        }
        return false;
    }
}
