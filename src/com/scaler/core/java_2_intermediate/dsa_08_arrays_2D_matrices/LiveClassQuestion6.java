package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices;

/**
 * @created 25/12/22 7:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion6 {
    /**
     * Given matrix mat[N][N]. Rotate it 90 degree clockwise from top right
     **/
    private static void rotateMatrix90Degree(int[][] A) {
        int r = A.length - 1;
        int c = A[0].length - 1;
        int temp = 0;
        // Take transpose of the matrix (swap the indexes)
        for (int i = 0; i <= r; i++) {
            for (int j = i; j <= c; j++) {
                temp = A[j][i];
                A[j][i] = A[i][j];
                A[i][j] = temp;
            }
        }
        // for clockwise rotation of 90 degree take row and then reverse each array
        for (int i = 0; i <= r; i++) {
            for (int j = 0, k = r; j <= k; j++, k--) {
                temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        rotateMatrix90Degree(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
