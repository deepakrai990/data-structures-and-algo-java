package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q4_Dungeon_Prince_and_Princess_1 {
    /**
     * Problem: 1Dungeon Prince and Princess
     * Given mat[N][M], where each cell indicates the health that you have gained.
     * Find minimum health required at start cell (0, 0) so that we can reach the last cell [N - 1][M - 1].
     * Note 1: Cell movement right or down
     * Note 2: If health reaches 0 at any place, you are dead.
     * Note 3: We start at (0, 0)
     * **/
    static int[][] DP;
    private static int solve(int[][] mat, int i, int j) {
        int N = mat.length;
        int M = mat[0].length;
        DP = new int[N][M];
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return minHealth(mat, i , j, N, M);
    }
    private static int minHealth(int[][] mat, int i, int j, int N, int M) {
        if (i >= N || j >= M) { return Integer.MAX_VALUE; }
        if (i == N - 1 && j == M - 1) {
            return Math.max(1, 1 - mat[i][j]);
        }
        if (DP[i][j] == -1) {
            int A = minHealth(mat, i + 1, j, N, M);
            int B = minHealth(mat, i, j + 1, N, M);
            DP[i][j] = Math.max(1, Math.min(A, B) - mat[i][j]);
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int[][] mat = {
                {-3, 2, 4, -7},
                {-6, 5, -4, 6},
                {-15, -8, 3, -4},
                {7, 4, -2, -7},
        };
        int result = solve(mat, 0, 0);
        PrintUtils.print(result);
    }
}
