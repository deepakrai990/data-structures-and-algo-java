package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 14/12/23
 * @project scaler_course_code
 */
public class Q2_Sudoku_3 {
    /**
     * Problem Statement:
     * Given a partially filled Sudoku grid represented by a 2D array mat,
     * where mat[i][j] = 0 denotes an empty cell and mat[i][j] != 0 denotes a filled cell,
     * fill in the empty cells such that every row, every column, and every 3x3 box contains
     * all elements from 1 to 9 without any duplicates.
     * <></>
     * Algorithm Explanation:
     * 1. Define a function isSafe to check if a given number can be placed in a particular cell.
     * 2. Define a recursive function solveSudokuUtil to fill in the Sudoku grid.
     * 3. Use HashSet (rowSet, colSet, and boxSet) to keep track of numbers used in each row, column, and 3x3 box.
     * 4. The base case for the recursion is when all cells are filled.
     * 5. Within the recursive function:
     *      Iterate through each cell.
     *      If the cell is empty, try placing numbers from 1 to 9.
     *      For each number, check if it is safe to place in the current cell using the isSafe function.
     *      If safe, place the number and recursively try to fill the rest of the grid.
     *      If a valid solution is found, return true.
     *      If no number leads to a solution, backtrack by resetting the cell to 0.
     * 6. Print the solution if it exists.
     * **/
    private static boolean isSafe(int[][] mat, int row, int col, int num, HashSet<Integer> rowSet, HashSet<Integer> colSet, HashSet<Integer>[] boxSet) {
        return !rowSet.contains(num) && !colSet.contains(num) && !boxSet[row / 3 * 3 + col / 3].contains(num);
    }
    private static boolean solveSudokuUtil(int[][] mat, HashSet<Integer>[] rowSet, HashSet<Integer>[] colSet, HashSet<Integer>[] boxSet) {
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(mat, i, j, num, rowSet[i], colSet[j], boxSet)) {
                            mat[i][j] = num;
                            rowSet[i].add(num);
                            colSet[j].add(num);
                            boxSet[i / 3 * 3 + j / 3].add(num);
                            if (solveSudokuUtil(mat, rowSet, colSet, boxSet)) {
                                return true;
                            }
                            mat[i][j] = 0;
                            rowSet[i].remove(num);
                            colSet[j].remove(num);
                            boxSet[i / 3 * 3 + j / 3].remove(num);
                        }
                    }
                    return false;  // No valid number found for this cell
                }
            }
        }
        return true;  // All cells are filled
    }
    private static void solveSudoku(int[][] mat) {
        int N = mat.length;
        HashSet<Integer>[] rowSet = new HashSet[N];
        HashSet<Integer>[] colSet = new HashSet[N];
        HashSet<Integer>[] boxSet = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        // Initialize the sets with the given numbers in the Sudoku grid
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] != 0) {
                    rowSet[i].add(mat[i][j]);
                    colSet[j].add(mat[i][j]);
                    boxSet[i / 3 * 3 + j / 3].add(mat[i][j]);
                }
            }
        }
        if (!solveSudokuUtil(mat, rowSet, colSet, boxSet)) {
            System.out.println("No solution exists.");
        } else {
            printSolution(mat, N);
        }
    }

    private static void printSolution(int[][] mat, int N) {
        System.out.println("Solution:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
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
        solveSudoku(mat);
    }
}
