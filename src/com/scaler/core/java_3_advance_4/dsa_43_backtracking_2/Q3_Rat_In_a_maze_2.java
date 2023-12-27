package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 14/12/23
 * @project scaler_course_code
 */
public class Q3_Rat_In_a_maze_2 {
    /**
     * Problem Statement:
     * Given a maze represented by a 2D array where 0 represents an open cell and 1 represents a blocked cell, find a path for a rat from the top-left corner to the bottom-right corner. The rat can only move in the right or down direction.
     * <></>
     * Algorithm Explanation:
     * <></>
     * 1. Define a function isSafe to check if the rat can move to a given position (i, j) in the maze.
     * 2. Define a recursive function solveMazeUtil to solve the maze starting from a given position (x, y).
     * 3. Use a HashSet (visited) to keep track of visited positions to avoid cycles.
     * 4. The base case for the recursion is when the rat reaches the bottom-right corner.
     * 5. Within the recursive function:
     *      Check if the current position is safe using the isSafe function.
     *      Mark the current position as visited in the HashSet.
     *      Recursively try to move right and down from the current position.
     *      If a valid path is found, return true.
     *      If neither right nor down leads to a solution, backtrack by removing the current position from the HashSet.
     * 6. Print the solution if it exists.
     * **/
    private static boolean isSafe(int[][] maze, int x, int y, int ROWS, int COLS, HashSet<String> visited) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && maze[x][y] == 0 && !visited.contains(x + "-" + y);
    }
    private static boolean solveMaze(int[][] maze, int ROWS, int COLS) {
        int[][] solution = new int[ROWS][COLS];
        HashSet<String> visited = new HashSet<>();
        if (!solveMazeUtil(maze, 0, 0, solution, ROWS, COLS, visited)) {
            System.out.println("No solution exists.");
            return false;
        }
        printSolution(solution, ROWS, COLS);
        return true;
    }
    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution, int ROWS, int COLS, HashSet<String> visited) {
        if (x == ROWS - 1 && y == COLS - 1) {
            solution[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y, ROWS, COLS, visited)) {
            solution[x][y] = 1;
            visited.add(x + "-" + y);

            if (solveMazeUtil(maze, x, y + 1, solution, ROWS, COLS, visited)) {
                return true;
            }
            if (solveMazeUtil(maze, x + 1, y, solution, ROWS, COLS, visited)) {
                return true;
            }
            solution[x][y] = 0;
            visited.remove(x + "-" + y);
            return false;
        }
        return false;
    }

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
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int ROWS = 6;
        int COLS = 5;
        boolean result = solveMaze(maze, ROWS, COLS);
        PrintUtils.printNewLine();
        PrintUtils.print(result);
    }
}
