package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 12/12/23
 * @project scaler_course_code
 */
public class Q1_N_Queens_2 {
    /**
     * Question 1
     * Given matrix mat[N][N]. Print all valid placements of N queens such that no queen can kill each others
     * Note: If two queens are present in the same row/ column / diagonal, they will kill each other.
     * With Optimized check function
     * **/
    private static void NQueens(int[][] mat, int N, int i, HashSet<Integer> columns,
                                HashSet<Integer> leftDiagonals, HashSet<Integer> rightDiagonals) {
        if (i == N) {
            printNQueens(mat);
            return;
        }
        // At ith row, choices?
        for (int j = 0; j < N; j++) {
            // Place the queen at mat[i][j]
            if (columns.contains(j) || leftDiagonals.contains(i - j) || rightDiagonals.contains(i + j)) {
                continue; // Skip placing the queen
            }
            mat[i][j] = 1;
            columns.add(j);
            leftDiagonals.add(i - j);
            rightDiagonals.add(i + j);
            NQueens(mat, N, i + 1, columns, leftDiagonals, rightDiagonals);
            mat[i][j] = 0;
            columns.remove(j);
            leftDiagonals.remove(i - j);
            rightDiagonals.remove(i + j);
        }
    }
    private static void printNQueens(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] mat = new int[N][N];
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> leftDiagonals = new HashSet<>();
        HashSet<Integer> rightDiagonals = new HashSet<>();
        NQueens(mat, N, 0, columns, leftDiagonals, rightDiagonals);
    }
}
