package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 01/04/23 11:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Matrix_and_Absolute_Difference {
    class Coordinate {
        int i;
        int j;

        Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int row[] = {-1, 1, 0, 0};
    int col[] = {0, 0, -1, 1};

    public int solve(int A, int B, int[][] C) {
        int left = 0, right = (int) 1e9;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (PossibleToVisitAll(mid, C)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean PossibleToVisitAll(int diff, int[][] C) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[C.length][C[0].length];
        queue.add(new Coordinate(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();
            int i = temp.i;
            int j = temp.j;
            for (int k = 0; k < 4; k++) {
                int x = i + row[k];
                int y = j + col[k];
                if (x >= 0 && y >= 0 && x < C.length && y < C[0].length && !visited[x][y] && Math.abs(C[i][j] - C[x][y]) <= diff) {
                    visited[x][y] = true;
                    queue.add(new Coordinate(x, y));
                }
            }

        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }
}
