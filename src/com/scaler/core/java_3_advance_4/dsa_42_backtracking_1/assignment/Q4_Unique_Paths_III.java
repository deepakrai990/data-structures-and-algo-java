package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.assignment;

/**
 * @created 02/04/23 11:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Unique_Paths_III {
    int count = 0;

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int si = -1;
        int sj = -1;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    si = i;
                    sj = j;
                }
                if (A[i][j] == 0)
                    zeroCount++;
            }
        }
        dfs(A, n, m, si, sj, zeroCount, 0);
        return count;

    }

    private void dfs(int[][] A, int row, int col, int x, int y, int zeroCount, int pathLength) {
        if (x < 0 || x >= row || y < 0 || y >= col || A[x][y] == -1)
            return;

        if (A[x][y] == 2) {
            if (pathLength == zeroCount + 1)
                count++;
            return;
        }
        int temp = A[x][y];
        A[x][y] = -1;
        dfs(A, row, col, x + 1, y, zeroCount, pathLength + 1);
        dfs(A, row, col, x - 1, y, zeroCount, pathLength + 1);
        dfs(A, row, col, x, y + 1, zeroCount, pathLength + 1);
        dfs(A, row, col, x, y - 1, zeroCount, pathLength + 1);
        A[x][y] = temp;
    }
}
