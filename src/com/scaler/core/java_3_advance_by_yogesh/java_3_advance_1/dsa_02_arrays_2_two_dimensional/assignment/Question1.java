package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.assignment;

/**
 * @created 19/01/23 11:37 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int[][] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int contribution = (i + 1) * (j + 1) * (n - i) * (n - j);
                sum += contribution * A[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1}, {1, 1}};
        int result = solve(A);
        System.out.println("Result : " + result);
    }
}
