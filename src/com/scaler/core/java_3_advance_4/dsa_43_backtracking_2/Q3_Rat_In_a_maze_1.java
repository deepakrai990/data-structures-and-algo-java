package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 14/12/23
 * @project scaler_course_code
 */
public class Q3_Rat_In_a_maze_1 {
    // Helper function to check if the rat can move to a given position
    private static boolean isSafe(int[][] maze, int x, int y, int ROWS, int COLS) {
        // Check if the position is within the maze bounds and is not blocked (1)
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && maze[x][y] == 0;
    }
    // Main function to solve the Rat in a Maze problem
    private static boolean solveMaze(int[][] maze, int ROWS, int COLS) {
        // Create a solution matrix to store the path of the rat
        int[][] solution = new int[ROWS][COLS];
        // Initialize the solution matrix with zeros
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                solution[i][j] = 0;
            }
        }
        // Try to solve the maze starting from the top-left corner
        if (!solveMazeUtil(maze, 0, 0, solution, ROWS, COLS)) {
            System.out.println("No solution exists.");
            return false;
        }
        // Print the solution if it exists
        printSolution(solution, ROWS, COLS);
        return true;
    }
    // Helper function to recursively solve the Rat in a Maze problem
    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution, int ROWS, int COLS) {
        // Base case: If the rat reaches the bottom-right corner, the maze is solved
        if (x == ROWS - 1 && y == COLS - 1) {
            solution[x][y] = 1;
            return true;
        }
        // Check if the current position is safe to move
        if (isSafe(maze, x, y, ROWS, COLS)) {
            // Mark the current position in the solution path
            solution[x][y] = 1;
            // Move to the right
            if (solveMazeUtil(maze, x, y + 1, solution, ROWS, COLS)) {
                return true;
            }
            // Move downward
            if (solveMazeUtil(maze, x + 1, y, solution, ROWS, COLS)) {
                return true;
            }
            // If neither right nor down is a valid move, backtrack
            solution[x][y] = 0;
            return false;
        }
        return false;
    }
    // Helper function to print the solution path
    private static void printSolution(int[][] solution, int ROWS, int COLS) {
        System.out.println("Solution:");

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int ROWS = 6;
        int COLS = 7;
        boolean result = solveMaze(maze, ROWS, COLS);
        PrintUtils.printNewLine();
        PrintUtils.print(result);
    }
}
