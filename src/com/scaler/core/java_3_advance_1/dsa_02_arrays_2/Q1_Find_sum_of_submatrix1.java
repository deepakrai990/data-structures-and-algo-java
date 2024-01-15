package com.scaler.core.java_3_advance_1.dsa_02_arrays_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 10/01/24
 * @project scaler_course_code
 */
public class Q1_Find_sum_of_submatrix1 { // not final
    /**
     * Problem: Given a matrix mat[N][M]. For each query Q, find the sun of the given submatrix
     * **/
    private static int querySubmatrixSum(int[][] prefixSum, int[] topLeft, int[] bottomRight) {
        int top = topLeft[0]; // a1
        int left = topLeft[1]; // a2
        int bottom = bottomRight[0]; // b1
        int right = bottomRight[1]; // b2
        int sum = prefixSum[bottom][right];
        if (top > 0) {
            sum = sum - prefixSum[top - 1][left];
        }
        if (left > 0) {
            sum = sum - prefixSum[bottom][left - 1];
        }
        if (top > 0 && left > 0) {
            sum = sum + prefixSum[top - 1][left - 1];
        }
        return sum;
    }
    private static int[][] precomputePrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a prefix sum matrix
        int[][] prefixSum = new int[rows + 1][cols + 1];

        // Fill the prefix sum matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        return prefixSum;
    }
    private static int[][] getPrefixSumMatrix(int[][] A) {
        /* Row-wise */
        int[][] pf = new int[A.length][A[0].length];
        for (int r = 0; r < A.length; r++) {
            int sum = 0;
            for (int c = 0; c < A[0].length; c++) {
                sum = sum + A[r][c];
                pf[r][c] = sum;
            }
        }
        /*  Column-wise */
        for (int c = 0; c < pf[0].length; c++) {
            int sum = 0;
            for (int r = 0; r < pf.length; r++) {
                sum = sum + pf[r][c];
                pf[r][c] = sum;
            }
        }
        return pf;
    }
    static int[][] calculatePrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefixSum = new int[rows][cols];
        // Calculate row-wise prefix sum
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = matrix[i][j];
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
            }
        }

        // Calculate column-wise prefix sum
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                prefixSum[i][j] = matrix[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
            }
        }


        return prefixSum;
    }

    public static void main(String[] args) {
        int[][] A = {
                {2, -1, 3, 2},
                {3, 2, 6, 2},
                {10, 9, 8, 2},
                {4, -1, 2, 3},
                {3, 2, 6, 9},
        };

        int[][] prefixSum = calculatePrefixSum(A);

        int[] query1TopLeft = {2, 1};
        int[] query1BottomRight = {4, 2};
        System.out.println("Query 1 Result: " + querySubmatrixSum(prefixSum, query1TopLeft, query1BottomRight));

        int[] query2TopLeft = {0, 0};
        int[] query2BottomRight = {1, 1};
        System.out.println("Query 2 Result: " + querySubmatrixSum(prefixSum, query2TopLeft, query2BottomRight));
    }

}
