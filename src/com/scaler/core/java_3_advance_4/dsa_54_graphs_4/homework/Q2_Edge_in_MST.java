package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 01/04/23 11:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Edge_in_MST {
    private static int[] solve(int A, int[][] B) {
        // Create parent array for Disjoint subset tree
        int[] parent = new int[A + 1];
        // Initially assign self loop for parent
        for (int i = 1; i <= A; i++)
            parent[i] = i;
        // Creates a new array C that will also have the index of the pair after sorting
        int[][] C = new int[B.length][4];
        for (int i = 0; i < B.length; i++) {
            C[i][0] = B[i][0];
            C[i][1] = B[i][1];
            C[i][2] = B[i][2];
            C[i][3] = i;
        }
        // Sort the newly Created array with weights
        Arrays.parallelSort(C, Comparator.comparingInt(c -> c[2]));
        int[] res = new int[B.length];
        int i = 0, j = 0;
        ;
        while (i < B.length) {
            j = i;
            // Checks for the same weighted nodes that can they be part of spanning tree
            while (j < B.length && C[i][2] == C[j][2]) {
                if (root(C[j][0], parent) != root(C[j][1], parent))
                    res[C[j][3]] = 1;
                j++;
            }
            j = i;
            // Merge the same weighted edges in a union if required
            while (j < B.length && C[i][2] == C[j][2]) {
                makeUnion(C[j][0], C[j][1], parent);
                j++;
            }
            i = j;
        }
        return res;
    }

    private static int root(int x, int[] parent) {
        if (x == parent[x])
            return x;
        parent[x] = root(parent[x], parent);
        return parent[x];
    }
    private static boolean makeUnion(int x, int y, int[] parent) {
        int xx = root(x, parent);
        int yy = root(y, parent);
        if (xx == yy)
            return false;
        parent[yy] = xx;
        return true;
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 2}, {1, 3, 2}, {2, 3, 3},};

        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
