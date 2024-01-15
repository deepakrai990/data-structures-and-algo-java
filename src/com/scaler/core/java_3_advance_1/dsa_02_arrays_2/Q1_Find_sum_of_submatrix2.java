package com.scaler.core.java_3_advance_1.dsa_02_arrays_2;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Find_sum_of_submatrix2 {
    /**
     * Problem: Given a matrix mat[N][M]. For each query Q, find the sun of the given submatrix
     * **/
    // Function to handle queries and find a submatrix sum
    private static int querySubmatrixSum(int[][] prefixSum, int[] topLeft, int[] bottomRight) {
        int top = topLeft[0];
        int left = topLeft[1];
        int bottom = bottomRight[0];
        int right = bottomRight[1];

        // Use a prefix sum to calculate the sum of the submatrix
        return prefixSum[bottom][right] - prefixSum[bottom][left - 1] - prefixSum[top - 1][right]
                + prefixSum[top - 1][left - 1];
    }
    // Function to precompute prefix sum matrix
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
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] prefixSum = precomputePrefixSum(matrix);

        // Example Queries:
        int[] query1TopLeft = {1, 1};
        int[] query1BottomRight = {2, 2};
        System.out.println("Query 1 Result: " + querySubmatrixSum(prefixSum, query1TopLeft, query1BottomRight));

        int[] query2TopLeft = {2, 2};
        int[] query2BottomRight = {3, 3};
        System.out.println("Query 2 Result: " + querySubmatrixSum(prefixSum, query2TopLeft, query2BottomRight));
    }
}
