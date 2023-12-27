package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic;

/**
 * @created 27/01/23 6:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Pascal’s Triangle
     * Pascal’s triangle is a triangular array of binomial coefficients.
     * Write a function that takes an integer value n as input and prints first n lines of Pascal’s triangle.
     * Following are the first 6 rows of Pascal’s Triangle.
     *
     *          1
     *          1 1
     *          1 2 1
     *          1 3 3 1
     *          1 4 6 4 1
     *          1 5 10 10 5 1
     * **/
    // Brute Force Approach
    private static void printPascal(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    arr[i][j] = 1;
                } else { // Other values are sum of values just above and left of above
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }

                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        printPascal(5);
    }
}
