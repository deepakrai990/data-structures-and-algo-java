package com.scaler.core.java_3_advance_4.dsa_52_graphs_2.homework;

import java.util.*;

/**
 * @created 02/04/23 8:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Poisonous_Graph {
    class Pair {
        int val;
        boolean isLeft;

        Pair(int val, boolean isLeft) {
            this.val = val;
            this.isLeft = isLeft;
        }
    }

    public int solve(int A, int[][] B) {

        long[] two = new long[A + 1];
        long mod = 998244353;
        two[0] = 1;
        // Stored the pre computed power of 2 as required in question
        // For each connected component in the graph the combinations
        // will be 2^EvenNode + 2^OddNodes (Considering it is a bipertate graph)
        // If the graph is not bipertate at any moment just return 0;
        // We have to multiply outcome of all the connected components in graph to get the answer
        for (int i = 1; i <= A; i++)
            two[i] = (two[i - 1] * 2) % mod;
        // HashSet that will have left and right set for bipertate graph
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        // Queue to run bfs on connected components of a graph
        Queue<Pair> q = new LinkedList<>();
        // HashMap to store graph edges for each node
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= A; i++)
            map.put(i, new ArrayList<>());
        for (int i = 0; i < B.length; i++) {
            int node1 = B[i][0];
            int node2 = B[i][1];
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        // Initial ans as 1 because we have to multiply with other connected components
        long ans = 1;
        // Visited array for all nodes.
        boolean[] vis = new boolean[A + 1];
        //for each node we will try to start a dfs if it is not visited
        // It is possible if we have n or more connected graph in the whole graph
        for (int i = 1; i <= A; i++) {
            // By default false but will set true if we find a new not visited connected graph
            boolean newComponent = false;
            if (!vis[i]) {
                // Clearing all the left and right sets for the new graph
                left.clear();
                right.clear();
                q.clear();
                q.add(new Pair(i, true));
                newComponent = true;
                // Run DFS and store the graph node in two sets left and right
                // to determine if we have a bipertate graph
                while (!q.isEmpty()) {
                    Pair pair = q.poll();
                    //System.out.println("Pair val :"+ pair.val+" isLeft :"+pair.isLeft);
                    vis[pair.val] = true;
                    if (pair.isLeft) {
                        left.add(pair.val);
                        for (Integer x : map.get(pair.val)) {
                            if (!vis[x]) {
                                q.add(new Pair(x, false));
                                right.add(x);
                                // If we have a poisonous graph or non-bipertate connected graph
                                // just return 0 as the answer as desired in question
                                if (left.contains(x)) {
                                    return 0;
                                }
                            }
                        }
                    } else {
                        right.add(pair.val);
                        for (Integer x : map.get(pair.val)) {
                            if (!vis[x]) {
                                q.add(new Pair(x, true));
                                left.add(x);
                                // If we have a poisonous graph or non-bipertate connected graph
                                // just return 0 as the answer as desired in question
                                if (right.contains(x)) {
                                    return 0;
                                }
                            }

                        }
                    }
                }

            }
            if (newComponent)
                ans = (ans * (two[left.size()] + two[right.size()])) % mod;
        }

        if (ans == 1)
            return 0;

        return (int) ans;
    }
}
