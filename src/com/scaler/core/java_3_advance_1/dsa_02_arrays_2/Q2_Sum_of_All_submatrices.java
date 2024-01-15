package com.scaler.core.java_3_advance_1.dsa_02_arrays_2;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q2_Sum_of_All_submatrices {
    /**
     * Problem: Given a matrix mat[N][M]. Find sum of all submatrices.
     * **/
    // Bruteforce Approach Function to find the sum of all submatrices (brute-force)
    private static int submatrixSum1(int[][] matrix) {
        int totalSum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int topRow = 0; topRow < rows; topRow++) {
            for (int leftCol = 0; leftCol < cols; leftCol++) {
                for (int bottomRow = topRow; bottomRow < rows; bottomRow++) {
                    for (int rightCol = leftCol; rightCol < cols; rightCol++) {
                        // Calculate sum for the current submatrix
                        for (int i = topRow; i <= bottomRow; i++) {
                            for (int j = leftCol; j <= rightCol; j++) {
                                totalSum += matrix[i][j];
                            }
                        }
                    }
                }
            }
        }
        return totalSum;
    }
    // Optimized Approach 1
    private static int submatrixSum2(int[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int contributions = (i + 1) * (j + 1) * (rows - i) * (cols - j);
                ans += matrix[i][j] * contributions;
            }
        }
        return ans;
    }
    // Optimized Approach 2 Function to find the sum of all submatrices (optimized)
    private static int submatrixSum3(int[][] matrix) {
        int totalSum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate the number of submatrices that include element (i, j)
                int upperLeftCount = (i + 1) * (j + 1);
                int lowerRightCount = (rows - i) * (cols - j);
                totalSum += matrix[i][j] * upperLeftCount * lowerRightCount;
            }
        }
        return totalSum;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 1},
                {-1, -2},
                {2, 4},
        };

        int result = submatrixSum1(matrix);
        System.out.println("Brute-force Approach - Total Sum of Submatrices: " + result);

        result = submatrixSum2(matrix);
        System.out.println("Optimized Approach 1 - Total Sum of Submatrices: " + result);

        result = submatrixSum3(matrix);
        System.out.println("Optimized Approach 2 - Total Sum of Submatrices: " + result);
    }
}
