package com.scaler.core.java_3_advance_4.dsa_52_graphs_2.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 8:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Distance_of_nearest_cell {
    private int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    A[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int count = temp[2];
            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int nRow = row[i] + r;
                int nCol = col[i] + c;
                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && A[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                    A[nRow][nCol] = count + 1;
                    q.add(new int[]{nRow, nCol, count + 1});
                    visited[nRow][nCol] = true;
                }
            }

        }
        return A;
    }
}
