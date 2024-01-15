package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Knight_On_Chess_Board {
    static class Pair {
        int row;
        int col;
        int step;

        Pair(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    private static int knight(int A, int B, int C, int D, int E, int F) {
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
                    int nRow = row + dx[i];
                    int mCol = col + dy[i];
                    if (isValid(nRow, mCol, A, B) && !chessBoard[nRow][mCol]) {
                        pq.add(new Pair(nRow, mCol, steps + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int nRow, int mCol, int n, int m) {
        return (nRow >= 0 & mCol >= 0 && nRow < n && mCol < m);
    }

    public static void main(String[] args) {
        int A = 8;
        int B = 8;
        int C = 1;
        int D = 1;
        int E = 8;
        int F = 8;

        int result = knight(A, B, C, D, E, F);
        PrintUtils.print(result);
    }
}
