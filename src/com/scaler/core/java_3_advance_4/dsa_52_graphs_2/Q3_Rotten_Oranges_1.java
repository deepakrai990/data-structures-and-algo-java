package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q3_Rotten_Oranges_1 {
    /**
     * Need to work
     * **/
    private static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;
        // Enqueue initial rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        // Helper array to explore adjacent positions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // BFS simulation
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> currentOrange = queue.poll();
                int row = currentOrange.getKey();
                int col = currentOrange.getValue();
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    // Check if the new position is within bounds and has a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        // Mark the orange as rotten and enqueue its coordinates
                        grid[newRow][newCol] = 2;
                        queue.offer(new Pair<>(newRow, newCol));
                        freshOranges--;
                    }
                }
            }
            if (!queue.isEmpty()) {
                // Increment time after each round of rotting
                time++;
            }
        }
        // Check if all oranges are rotten
        return (freshOranges == 0) ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int minTime = orangesRotting(grid);

        System.out.println("Minimum Time to Rot All Oranges: " + minTime);
    }
}
