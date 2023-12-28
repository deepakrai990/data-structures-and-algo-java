package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.homework;

import java.util.Arrays;

/**
 * @created 26/09/22 7:32 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Matrix_Scalar_Product {
    /**
     * Q1. Matrix Scalar Product
     * <p>
     * Problem Description
     * You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix
     * A with an integer B.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size() <= 1000
     * <p>
     * 1 <= A[i].size() <= 1000
     * <p>
     * 1 <= A[i][j] <= 1000
     * <p>
     * 1 <= B <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is 2D array of integers A representing matrix.
     * <p>
     * Second argument is an integer B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * You have to return a 2D array of integers after doing required operations.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = 2
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * ==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
     * ==> [[2*1, 2*2, 2*3],[2*4, 2*5, 2*6],[2*7, 2*8, 2*9]]
     * ==> [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
     **/
    private static int[][] solve(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                A[row][col] = A[row][col] * B;
            }
        }
        return A;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Just multiply the value B with each and every element of the matrix.
     * <p>
     * Solution Approach
     * Run a outer loop from i = 1  to i = row,
     * Run a inner loop from j = 1  to j = col,
     * Do A[i][j]*B for all elements,
     * return the updated matrix.
     **/
    private static int[][] solve1(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                A[i][j] *= B;
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int B = 2;
        int[][] results = solve(A, B);
        System.out.println(Arrays.deepToString(results));
        results = solve1(A, B);
        System.out.println(Arrays.deepToString(results));
    }
}
