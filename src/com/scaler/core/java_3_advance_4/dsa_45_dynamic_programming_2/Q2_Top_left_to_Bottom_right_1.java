package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q2_Top_left_to_Bottom_right_1 {
    /**
     * Problem: No of ways to go from TL (Top Left) (0,0) to BR (Bottom right) (n - i, m - 1) cells using
     * only two directional movements right (->) and down
     * **/
    static int[][] DP;
    private static int solve(int N, int M) {
        DP = new int[N][M];
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return ways(N - 1, M - 1);
    }
    private static int ways(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (DP[i][j] == -1) {
            DP[i][j] = ways(i - 1, j) + ways(i, j - 1);
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int N = 4;
        int M = 5;
        int result = solve(N, M);
        PrintUtils.print(result);
    }
}
