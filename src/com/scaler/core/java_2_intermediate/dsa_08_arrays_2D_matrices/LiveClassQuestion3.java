package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices;

/**
 * @created 25/12/22 8:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given squire matrix mat[N][N]. Print diagonals.
     * 1. left to right
     * 2. right to left
     * **/
    private static void printDiagonalsLeftToRight(int[][] matrix, int n) {
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            System.out.println(matrix[i][j]);
            i++;
            j++;
        }
    }
    /**
     * 2. right to left
     * **/
    private static void printDiagonalsRightToLeft(int[][] matrix, int n) {
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            System.out.println(matrix[i][j]);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{4,3,1,7}, {6,2,3,4}, {5,3,2,7}, {-6,3,-3,-4}};
        int n = 4;
        printDiagonalsLeftToRight(matrix, n);
        System.out.println("-------------------------");
        printDiagonalsRightToLeft(matrix, n);
    }
}
