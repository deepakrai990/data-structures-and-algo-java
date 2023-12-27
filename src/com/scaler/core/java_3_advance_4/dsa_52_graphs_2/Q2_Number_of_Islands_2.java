package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q2_Number_of_Islands_2 {
    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islandCount;
    }

    private static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Base cases
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        // Explore neighbors (up, down, left, right)
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '1', '1'}
        };

        int islandCount = numIslands(grid);

        System.out.println("Number of Islands: " + islandCount);
    }
}
