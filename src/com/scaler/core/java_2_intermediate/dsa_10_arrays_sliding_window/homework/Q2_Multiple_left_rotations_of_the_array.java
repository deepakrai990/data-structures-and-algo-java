package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 14/09/22 2:04 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Multiple_left_rotations_of_the_array {
    private static int[][] solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = A[(B[i] + j) % n];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3};
        int[][] results = solve(A, B);
        PrintUtils.print2DArray(results);
    }
}
