package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.homework;

/**
 * @created 02/04/23 8:33 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Black_Shapes {
    private int black(String[] A) {
        int n = A.length;
        int m = A[0].length();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = A[i].toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    count++;
                    bfs(i, j, n, m, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int x, int y, int n, int m, char[][] grid) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 'O')
            return;
        grid[x][y] = 'O';
        bfs(x + 1, y, n, m, grid);
        bfs(x - 1, y, n, m, grid);
        bfs(x, y + 1, n, m, grid);
        bfs(x, y - 1, n, m, grid);
    }
}
