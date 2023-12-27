package com.scaler.contest.tct_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 4:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Number_of_Islands_11 {
    private static int solve(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int rows = A.length;
        int colums = A[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (A[i][j] == 1) {
                    count++;
                    dfs(A, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] A, int row, int col) {
        int rows = A.length;
        int columns = A[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= columns || A[row][col] == 0) {
            return;
        }
        A[row][col] = 0;
        dfs(A, row + 1, col);
        dfs(A, row - 1, col);
        dfs(A, row, col + 1);
        dfs(A, row, col - 1);
    }
    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        int result = solve(A);
        PrintUtils.print(result);
    }
}
