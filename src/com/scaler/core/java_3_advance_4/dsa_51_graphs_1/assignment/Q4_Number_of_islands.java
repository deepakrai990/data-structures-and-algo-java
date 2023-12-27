package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.assignment;

/**
 * @created 02/04/23 8:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Number_of_islands {
    public int solve(int[][] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    ans++;
                    dfs(i, j, A);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] A) {
        A[i][j] = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int x = i + dx;
                int y = j + dy;
                if (x >= 0 && y >= 0 && x < A.length && y < A[0].length && A[x][y] != 0) {
                    dfs(x, y, A);
                }
            }
        }
    }

    private int solve_1(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    count++;
                    bfs_1(i, j, n, m, A);
                }
            }
        }
        return count;
    }

    private static void bfs_1(int x, int y, int n, int m, int[][] A) {
        if (x < 0 || x >= n || y < 0 || y >= m || A[x][y] == 0)
            return;
        A[x][y] = 0;
        bfs_1(x - 1, y, n, m, A);
        bfs_1(x, y - 1, n, m, A);
        bfs_1(x + 1, y, n, m, A);
        bfs_1(x, y + 1, n, m, A);
        bfs_1(x - 1, y - 1, n, m, A);
        bfs_1(x + 1, y + 1, n, m, A);
        bfs_1(x - 1, y + 1, n, m, A);
        bfs_1(x + 1, y - 1, n, m, A);
    }
}
