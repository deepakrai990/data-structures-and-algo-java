package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices;

/**
 * @created 25/12/22 7:44 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given mat[N][M]. Print row wise sum.
     */
    private static void printRowWiseSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[i][j];
            }
            System.out.printf("%s%4d\n", "Row sum: ", sum);
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{4,3,1,7}, {6,2,3,4}, {5,3,2,7}};
        printRowWiseSum(matrix);
    }
}
