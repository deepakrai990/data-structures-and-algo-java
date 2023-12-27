package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.assignment;

/**
 * @created 02/04/23 10:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Edit_Distance {
    int[][] dpArr;

    private int minDistance(String A, String B) {
        dpArr = new int[A.length()][B.length()];
        return recursion(A, B, 0, 0);
    }

    private int recursion(String A, String B, int i, int j) {
        if (i == A.length()) return B.length() - j;
        if (j == B.length()) return A.length() - i;

        if (dpArr[i][j] != 0) return dpArr[i][j];

        if (A.charAt(i) == B.charAt(j)) {
            dpArr[i][j] = recursion(A, B, i + 1, j + 1);
            return dpArr[i][j];
        } else {
            int ifReplaced = recursion(A, B, i + 1, j + 1) + 1;
            int ifDeleted = recursion(A, B, i + 1, j) + 1;
            int ifInserted = recursion(A, B, i, j + 1) + 1;
            dpArr[i][j] = Math.min(ifDeleted, Math.min(ifInserted, ifReplaced));
            return dpArr[i][j];
        }
    }
}
