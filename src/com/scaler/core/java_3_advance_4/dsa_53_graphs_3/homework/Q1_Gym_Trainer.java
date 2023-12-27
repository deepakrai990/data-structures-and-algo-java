package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.homework;

import java.util.*;

/**
 * @created 01/04/23 11:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Gym_Trainer {
    List<List<Integer>> adjList;

    private int solve(int A, int[][] B, int[][] C) {
        adjList = new ArrayList<>();
        Set<Integer> likeToWalk = new HashSet<>(); //maintaining a set of persons who like to walk
        boolean[] visited = new boolean[A + 1];
        for (int i = 0; i <= A; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];
            likeToWalk.add(a);
            likeToWalk.add(b);
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        //while creating adjList of C we can check the base condition of intersection if 2 diff type of friends intersecting
        for (int i = 0; i < C.length; i++) {
            int a = C[i][0];
            int b = C[i][1];
            if (likeToWalk.contains(a) || likeToWalk.contains(b))
                return 0;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int differentGroups = 0;
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                differentGroups++;
                bfs(i, visited);
            }
        }
        //we can distribute the diet in 2 ^differentGroups ways
        int mod = 1000000007;
        return fastPower(differentGroups, 2, mod);
    }

    private void bfs(int node, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int neighbor : adjList.get(temp)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    private int fastPower(int power, int base, int mod) {
        if (power == 0)
            return 1;
        long temp;
        if (power % 2 == 0) {
            temp = fastPower(power / 2, base, mod);
            temp = (temp % mod * temp % mod) % mod;
        } else {
            temp = base % mod;
            temp = (temp * fastPower(power - 1, base, mod) % mod) % mod;
        }
        return (int) (temp + mod) % mod;
    }
}
