package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices;

/**
 * @created 25/12/22 1:42 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Print_all_diagonals_going_from_right_to_left {
    /**
     * Given mat[N][M], print all diagonals going from right to left.
     * **/
    private static void printAllDiagonalsRightToLeft(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Print all diagonals in 0th row
        for (int j = 0; j < m; j++) {
            int r = 0;
            int l = j;
            // print diagonals from Right(r) to left(l)
            while (r < n && l >= 0) {
                System.out.print(matrix[r][l] +" ");
                r++;
                l--;
            }
            System.out.println();
        }
        // Print all diagonals in las column ((m - 1)th column)
        for (int i = 1; i < n; i++) {
            int r = i;
            int l = m - 1;
            while (r < n && l >=0) {
                System.out.print(matrix[r][l]+" ");
                r++;
                l--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        printAllDiagonalsRightToLeft(matrix);
    }
}
