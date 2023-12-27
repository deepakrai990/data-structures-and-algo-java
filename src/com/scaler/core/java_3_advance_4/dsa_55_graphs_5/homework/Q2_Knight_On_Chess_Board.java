package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Knight_On_Chess_Board {
    class Pair {
        int row;
        int col;
        int step;

        Pair(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] chessBoard = new boolean[A][B];
        int[] dx = new int[]{-2, -2, 1, -1, 2, 2, 1, -1};
        int[] dy = new int[]{1, -1, 2, 2, 1, -1, -2, -2};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.step - b.step);
        pq.add(new Pair(C - 1, D - 1, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int steps = p.step;
            if (row == E - 1 && col == F - 1) {
                return steps;
            }
            if (!chessBoard[row][col]) {
                chessBoard[row][col] = true;
                for (int i = 0; i < dx.length; i++) {
                    int nrow = row + dx[i];
                    int mcol = col + dy[i];
                    if (isValid(nrow, mcol, A, B) && !chessBoard[nrow][mcol]) {
                        pq.add(new Pair(nrow, mcol, steps + 1));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int nrow, int mcol, int n, int m) {
        return (nrow >= 0 & mcol >= 0 && nrow < n && mcol < m);
    }
}
