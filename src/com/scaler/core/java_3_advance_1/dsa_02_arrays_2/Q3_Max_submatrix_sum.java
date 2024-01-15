package com.scaler.core.java_3_advance_1.dsa_02_arrays_2;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q3_Max_submatrix_sum {
    /**
     * Problem: Given a matrix mat[N][M]. Find max submatrix sum
     * **/
    private static int maxSubmatrixSum1(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int N = matrix.length;
        int M = matrix[0].length;
        for (int start = 0; start < N; start++) {
            int[] sums = new int[M];
            for (int end = start; end < N; end++) {
                for (int j = 0; j < M; j++) {
                    sums[j] += matrix[end][j];
                }
            }
            ans = Math.max(ans, kadane(sums));
        }
        return ans;
    }
    private static int kadane(int[] A) {
        int N = A.length, sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum = sum + A[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
    // Function to find the maximum submatrix sum (optimized using Kadane's algorithm)
    static int maxSubmatrixSum2(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int topRow = 0; topRow < rows; topRow++) {
            int[] temp = new int[cols];
            // Iterate through all possible pairs of rows (topRow, bottomRow)
            for (int bottomRow = topRow; bottomRow < rows; bottomRow++) {
                // Update a temp array with the sum of elements between rows topRow and bottomRow
                for (int col = 0; col < cols; col++) {
                    temp[col] += matrix[bottomRow][col];
                }
            }
            // Use Kadane's algorithm to find the maximum subarray sum
            int currentSum = temp[0];
            int maxEndingHere = temp[0];
            for (int i = 1; i < cols; i++) {
                maxEndingHere = Math.max(temp[i], maxEndingHere + temp[i]);
                currentSum = Math.max(currentSum, maxEndingHere);
            }
            // Update maxSum if the current submatrix sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[][] mat = {
                {-3, 2, 3, 4, -6, 4},
                {5, 5, -5, 2, 2, -7},
                {-4, -3, 1, -1, 1, 4},
        };

        int result = maxSubmatrixSum1(mat);
        System.out.println("Brute-force Approach - Maximum Submatrix Sum: " + result);

        result = maxSubmatrixSum2(mat);
        System.out.println("Optimized Approach - Maximum Submatrix Sum: " + result);
    }
}
