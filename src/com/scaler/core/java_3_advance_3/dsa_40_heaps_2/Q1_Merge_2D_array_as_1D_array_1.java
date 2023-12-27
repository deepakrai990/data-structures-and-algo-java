package com.scaler.core.java_3_advance_3.dsa_40_heaps_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 27/11/23
 * @project scaler_course_code
 */
public class Q1_Merge_2D_array_as_1D_array_1 {
    static class Cell {
        int row, col, value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    /**
     * Question: Given 2D matrix[N][M]. Every row is sorted, merge entire data into 1D sorted list
     * and return sorted array.
     * **/
    private static int[] mergeSortedArrays(int[][] matrix) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int[] result = new int[totalRows * totalCols];
        int resultIndex = 0;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.value));
        // Initialize the min-heap with the first element from each row
        for (int i = 0; i < totalRows; i++) {
            minHeap.offer(new Cell(i, 0, matrix[i][0]));
        }

        // Merge
        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();
            result[resultIndex++] = current.value;
            // If there's a next element in the same row, add it to the min-heap
            if (current.col + 1 < totalCols) {
                minHeap.offer(new Cell(current.row, current.col + 1, matrix[current.row][current.col + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 4, 6},
                {0, 7, 8}
        };
        int[] sortedArray = mergeSortedArrays(matrix);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
