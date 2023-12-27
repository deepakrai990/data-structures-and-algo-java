package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

/**
 * @author Deepak Kumar Rai
 * @created 14/12/23
 * @project scaler_course_code
 */
public class Q2_Sudoku_2 {
    // Helper function to check if it's safe to place a number in a given position
    private static boolean isSafe(int[][] board, int row, int col, int num) {
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
    // Main function to solve the Sudoku puzzle using backtracking
    private static boolean solveSudoku(int[][] board) {
        // Find an empty slot (unassigned) in the Sudoku puzzle
        int[] emptySlot = findEmptySlot(board);
        int row = emptySlot[0];
        int col = emptySlot[1];
        // If there is no empty slot, the puzzle is solved
        if (row == -1 && col == -1) {
            return true;
        }
        // Try placing a number from 1 to 9 in the current empty slot
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                // Place the number in the current slot
                board[row][col] = num;
                // Recur to solve the rest of the puzzle
                if (solveSudoku(board)) {
                    return true;
                }
                // If placing the current number doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }
        // If no number can be placed, backtrack
        return false;
    }
    // Helper function to find an empty slot in the Sudoku puzzle
    private static int[] findEmptySlot(int[][] board) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    // Function to print the Sudoku board
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (solveSudoku(board)) {
            System.out.println("Sudoku solution:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
