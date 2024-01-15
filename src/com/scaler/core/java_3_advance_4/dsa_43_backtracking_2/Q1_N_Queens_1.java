package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

/**
 * @author Deepak Kumar Rai
 * @created 11/12/23
 * @project scaler_course_code
 */
public class Q1_N_Queens_1 {
    /**
     * Question 1
     * Given matrix mat[N][N]. Print all valid placements of N queens such that no queen can kill each others
     * Note: If two queens are present in the same row / column / diagonal, they will kill each other.
     * **/
    private static void NQueens(int[][] mat, int N, int i) {
        if (i == N) {
            printNQueens(mat);
            return;
        }
        // At ith row, choices?
        for (int j = 0; j < N; j++) {
            // Place the queen at mat[i][j]
            if (check(mat, i, j)) {
                mat[i][j] = 1;
                NQueens(mat, N, i + 1);
                mat[i][j] = 0;
            }
        }
    }
    private static boolean check(int[][] board, int row, int col) {
        // Check if no queens are in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // Check if no queens are in the left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check if no queens are in the right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // If no conflicts, placement is valid
        return true;
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
        NQueens(mat, N, 0);
    }
}
