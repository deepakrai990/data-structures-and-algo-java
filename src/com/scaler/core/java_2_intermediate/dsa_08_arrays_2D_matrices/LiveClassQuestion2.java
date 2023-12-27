package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices;

/**
 * @created 25/12/22 7:58 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given mat[N][M]. Print column wise sum.
     */
    private static void printColumnWiseSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[j][i];
            }
            System.out.printf("%s%4d\n", "Row sum: ", sum);
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{4,3,1,7}, {6,2,3,4}, {5,3,2,7}};
        printColumnWiseSum(matrix);
    }
}
