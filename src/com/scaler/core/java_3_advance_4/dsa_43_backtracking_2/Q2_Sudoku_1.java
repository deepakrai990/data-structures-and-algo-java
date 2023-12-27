package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

/**
 * @author Deepak Kumar Rai
 * @created 12/12/23
 * @project scaler_course_code
 */
public class Q2_Sudoku_1 {
    private static void sudoku(int[][] mat, int i) {
        if (i == 81) {
            // Print the mat[][]
            printBoard(mat);
            return;
        }
        // At ith 1-D index, get row & column values
        int row = i % 9, column = i % 9;
        if (mat[row][column] != 0) { // The Cell is already filled
            sudoku(mat, i + 1);
        } else { // The Cell is empty, choices are One to Nine
            for (int j = 1; j <= 9; j++) {
                // Keep data at mat[row][column] = j
                if (check(mat, row, column, j)) {
                    mat[row][column] = j;
                    sudoku(mat, i + 1);
                    mat[row][column] = 0;
                }
            }
        }
    }
    private static boolean check(int[][] board, int row, int col, int num) {
        // Check if 'num' is not already present in the current row and column
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        // Check if 'num' is not already present in the 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat = {
                {5, 3, 1, 2, 7, 6, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        sudoku(mat, mat.length);
    }
}
