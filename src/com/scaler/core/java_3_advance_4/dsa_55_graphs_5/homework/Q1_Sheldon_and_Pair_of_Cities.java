package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 01/04/23 11:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sheldon_and_Pair_of_Cities {
    private static final int INF = Integer.MAX_VALUE;

    private static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int[][] adjMatrix = new int[A + 1][A + 1];
        fillGraph(adjMatrix, A, B, D, E, F);
        calculateMinDistance(adjMatrix, A);

        int[] ans = new int[C];
        for (int i = 0; i < C; i++) {
            int u = G[i], v = H[i];
            ans[i] = adjMatrix[u][v] == INF ? -1 : adjMatrix[u][v];
        }
        return ans;
    }

    // Fill graph - Adjacency matrix
    private static void fillGraph(int[][] adjMatrix, int A, int B, int[] D, int[] E, int[] F) {
        // Intialising with expected distances
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= A; j++) {
                adjMatrix[i][j] = i == j ? 0 : INF;
            }
        }

        // Updating with given distances
        for (int i = 0; i < B; i++) {
            int u = D[i], v = E[i], dis = F[i];
            if (u != v && dis < adjMatrix[u][v]) {
                adjMatrix[u][v] = dis;
                adjMatrix[v][u] = dis;
            }
        }
    }

    // Floyd-Warshall Algo - Precalculating Distance
    private static void calculateMinDistance(int[][] cities, int A) {
        for (int k = 1; k <= A; k++) {
            for (int i = 1; i <= A; i++) {
                for (int j = 1; j <= A; j++) {
                    if (cities[i][k] != INF && cities[k][j] != INF)
                        cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 6;
        int C = 2;
        int[] D = {1, 2, 3, 2, 4, 3};
        int[] E = {2, 3, 4, 4, 1, 1};
        int[] F = {4, 1, 1, 1, 1, 1};
        int[] G = {1, 1};
        int[] H = {2, 3};

        int[] results = solve(A, B, C, D, E, F, G, H);
        PrintUtils.print(results);
    }
}
