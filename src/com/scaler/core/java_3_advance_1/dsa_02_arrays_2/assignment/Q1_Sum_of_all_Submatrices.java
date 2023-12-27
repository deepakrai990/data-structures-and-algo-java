package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_of_all_Submatrices {
    private static int solve(int[][] A) {
        int n = A.length;
        int freq = 0;
        int sum = 0;
        for(int i=0; i < n; i++) {
            for(int j= 0; j < n; j++) {
                freq = (i + 1) *(j + 1) * (n -i) * (n - j);
                sum = sum + freq * A[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
