package com.scaler.core.java_3_advance_4.dsa_53_graphs_3.homework;

/**
 * @created 01/04/23 11:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Cows_and_snacks {
    int[] parent;
    int[] height;

    private int solve(int A, int[][] B) {
        parent = new int[A + 1];
        height = new int[A + 1];
        int count = 0;
        for (int i = 1; i <= A; i++)
            parent[i] = i;
        for (int i = 0; i < B.length; i++) {
            if (!union(B[i][0], B[i][1]))
                count++;
        }
        return count;
    }

    private boolean union(int a, int b) {
        int u = findParent(a);
        int v = findParent(b);
        if (u == v) return false;
        if (height[u] > height[v]) {
            parent[v] = u;
        } else if (height[u] < height[v]) {
            parent[u] = v;
        } else {
            parent[v] = u;
            height[u]++;
        }
        return true;
    }

    private int findParent(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = findParent(parent[x]);
        return parent[x];
    }
}
