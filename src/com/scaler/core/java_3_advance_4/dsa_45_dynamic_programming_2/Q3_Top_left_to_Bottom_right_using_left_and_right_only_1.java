package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q3_Top_left_to_Bottom_right_using_left_and_right_only_1 {
    /**
     * Problem: Number of ways to go from TL (Top Left) to BR (Bottom Right)
     * using right (->) and left only (<-)
     * Note 1: mat[i][j] = 0 (blocked), mat[i][j] = 1 (unblocked).
     * Note 2: A path cannot go from a blocked cell.
     * **/
    static int[][] DP;
    private static int solve(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        // Create a memoization array to store computed results
        DP = new int[N][M];
        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }
        return ways(N - 1, M - 1, mat);
    }
    private static int ways(int i, int j, int[][] mat) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (mat[i][j] == 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (DP[i][j] == -1) {
            DP[i][j] = ways(i - 1, j, mat) + ways(i, j - 1, mat);
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };
        int result = solve(mat);
        PrintUtils.print(result);
    }
}
