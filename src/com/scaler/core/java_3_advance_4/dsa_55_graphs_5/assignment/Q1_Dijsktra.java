package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Dijsktra {
    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    public int[] solve(int A, int[][] B, int C) {
        ArrayList<Pair>[] graph = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            graph[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return (p1.weight - p2.weight);
            }
        });

        queue.add(new Pair(C, 0));

        while (!queue.isEmpty()) {
            Pair top = queue.remove();
            int nu = top.node;
            int wu = top.weight;
            if (dist[nu] == Integer.MAX_VALUE) {

                dist[nu] = wu;

                for (Pair p : graph[nu]) {
                    int nv = p.node;
                    int wv = p.weight;
                    if (dist[nv] == Integer.MAX_VALUE) {
                        queue.add(new Pair(nv, dist[nu] + wv));
                    }
                }
            }
        }

        for (int i = 0; i < A; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
