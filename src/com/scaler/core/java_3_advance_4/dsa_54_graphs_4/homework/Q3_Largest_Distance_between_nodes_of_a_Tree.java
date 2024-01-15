package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 01/04/23 11:48 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Largest_Distance_between_nodes_of_a_Tree {
    private int diameter = 0;

    private int solve(int[] A) {
        List<List<Integer>> adj = buildGraph(A);
        dfs(adj, 0);
        return diameter;
    }

    private int dfs(List<List<Integer>> adj, int source) {
        int maxHeight = 0;
        for (Integer child : adj.get(source)) {
            int currHeight = dfs(adj, child);
            diameter = Math.max(diameter, currHeight + maxHeight + 1);
            maxHeight = Math.max(maxHeight, currHeight + 1);
        }
        return maxHeight;
    }

    private List<List<Integer>> buildGraph(int[] input) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < input.length; i++) {
            int elem = input[i];
            if (elem == -1)
                continue;

            list.get(elem).add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 0};

        Q3_Largest_Distance_between_nodes_of_a_Tree solution = new Q3_Largest_Distance_between_nodes_of_a_Tree();
        int result = solution.solve(A);
        PrintUtils.print(result);
    }
}
