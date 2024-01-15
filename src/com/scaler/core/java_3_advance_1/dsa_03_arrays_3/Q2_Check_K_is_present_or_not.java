package com.scaler.core.java_3_advance_1.dsa_03_arrays_3;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q2_Check_K_is_present_or_not {
    /**
     * Problem: Given a 2D matrix mat[N][M]. Every row and column is sorted.
     * Check if the given element K is present or not.
     * **/
    private static boolean searchKInMatrix(int[][] mat, int K) {
        int N = mat.length;
        int M = mat[0].length;
        // Start from the top-right corner
        int i = 0, j = M - 1;
        while (i < N && j >= 0) {
            if (mat[i][j] == K) {
                return true; // Element found
            } else if (mat[i][j] > K) {
                j--; // Move to the left (decrement column)
            } else {
                i++; // Move down (increment row)
            }
        }
        return false; // Element not found
    }
    public static void main(String[] args) {
        int[][] mat = {
                {-1, 2, 4, 5, 9, 11},
                {1, 4, 7, 8 ,10, 14},
                {3, 7, 9, 10, 12, 18},
                {6, 10, 12, 14, 16, 20},
                {9, 13, 16, 19, 22, 24},
                {11, 15, 19, 21, 24, 27},
                {14, 20, 25, 29, 31, 39},
                {18, 24, 29, 32, 34, 42},
        };
        int K = 15; // 26;

        boolean result = searchKInMatrix(mat, K);
        System.out.println("Element " + K + " present: " + result);
    }
}
