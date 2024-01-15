package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window;

/**
 * @author Deepak Kumar Rai
 * @created 03/01/24
 * @project scaler_course_code
 */
public class Q3_Print_the_boundary_in_clockwise_direction {
    private static void printBoundary(int[][] mat) {
        int N = mat.length;
        int row =  0, column = 0;
        // Top row: Left to right
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            column++;
        }
        // Last column: top to bottom
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            row++;
        }
        // Last row: Right to left
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            column--;
        }
        // First Column: Bottom to top
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            row--;
        }
    }
    public static void main(String[] args) {int[][] A = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        printBoundary(A);
    }
}
