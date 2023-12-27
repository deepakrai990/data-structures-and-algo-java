package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.homework;

/**
 * @created 02/04/23 9:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Longest_Palindromic_Subsequence {
    int[][] dpArr;

    private int solve(String A) {
        dpArr = new int[A.length()][A.length()];
        return recursion(A, 0, A.length() - 1);
    }

    private int recursion(String A, int i, int j) {
        if (i == A.length() || j < 0) return 0;

        if (dpArr[i][j] != 0) return dpArr[i][j];

        if (A.charAt(i) == A.charAt(j)) {
            dpArr[i][j] = recursion(A, i + 1, j - 1) + 1;
            return dpArr[i][j];
        } else {
            int x = recursion(A, i + 1, j);
            int y = recursion(A, i, j - 1);
            dpArr[i][j] = Math.max(x, y);
            return dpArr[i][j];
        }
    }
}
