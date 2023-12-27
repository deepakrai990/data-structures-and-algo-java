package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

/**
 * @created 01/04/23 11:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sheldon_and_Pair_of_Cities {
    final int INF = Integer.MAX_VALUE;

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
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
    private void fillGraph(int[][] adjMatrix, int A, int B, int[] D, int[] E, int[] F) {
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

    // Floyd-Warshal Algo - Precalculating Distance
    private void calculateMinDistance(int[][] cities, int A) {
        for (int k = 1; k <= A; k++) {
            for (int i = 1; i <= A; i++) {
                for (int j = 1; j <= A; j++) {
                    if (cities[i][k] != INF && cities[k][j] != INF)
                        cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                }
            }
        }
    }
}
