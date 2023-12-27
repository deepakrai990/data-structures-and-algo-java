package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.assignment;

/**
 * @created 01/04/23 11:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Floyd_Warshall_Algorithm {
    public int[][] solve(int[][] A) {
        int rows = A.length, cols = A[0].length;
        int[][] ans = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (A[row][col] == -1) {
                    ans[row][col] = 1000000; //as per the constraints the max value < 1000000, so we can change -1 to 1000000
                } else {
                    ans[row][col] = A[row][col];
                }
            }
        }

        for (int k = 0; k < rows; k++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    ans[row][col] = Math.min(ans[row][col], ans[row][k] + ans[k][col]);
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (ans[row][col] == 1000000) {
                    ans[row][col] = -1;
                }
            }
        }

        return ans;
    }
}
