package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.homework;

import java.util.*;

/**
 * @created 01/04/23 11:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Maximum_Depth {
    List<List<Integer>> adj;
    int maxDepth = 0;

    private int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        //1.will create adjacency List
        adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }
        //2. maintaining visited array
        boolean[] visited = new boolean[A + 1];

        //3. for each query pre processed map
        Map<Integer, TreeSet<Integer>> nodesWithLevel = levelOrderTraversal(visited, D);
        // System.out.println(nodesWithLevel);

        //query time
        int[] response = new int[E.length];
        for (int i = 0; i < E.length; i++) {
            int level = E[i] % maxDepth;
            int val = F[i];
            Integer ans = nodesWithLevel.get(level).ceiling(val); //inbuilt binary search to find val
            if (ans != null)
                response[i] = ans;
            else
                response[i] = -1;
        }

        return response;
    }

    private Map<Integer, TreeSet<Integer>> levelOrderTraversal(boolean[] visited, int[] D) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int level = 0;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int temp = q.poll();
                if (!map.containsKey(level)) {
                    map.put(level, new TreeSet<>());
                }
                map.get(level).add(D[temp - 1]);
                for (Integer neighbor : adj.get(temp)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            level++;
        }
        maxDepth = level;
        return map;
    }
}
