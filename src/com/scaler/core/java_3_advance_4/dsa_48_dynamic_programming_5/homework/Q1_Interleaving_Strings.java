package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.homework;

import java.util.Arrays;

/**
 * @created 02/04/23 10:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Interleaving_Strings {
    int[][] dpArr;

    private int isInterleave(String A, String B, String C) {
        if (A.length() + B.length() != C.length()) {
            return 0;
        }
        dpArr = new int[A.length() + 1][B.length() + 1];
        for (int[] x : dpArr) {
            Arrays.fill(x, -1);
        }
        return recursion(A, B, C, 0, 0, 0);
    }

    private int recursion(String A, String B, String C, int i, int j, int k) {
        if (k == C.length()) {
            return 1;
        }
        if (i == A.length()) {
            if (B.substring(j).equals(C.substring(k))) {
                return 1;
            } else {
                return 0;
            }
        }
        if (j == B.length()) {
            if (A.substring(i).equals(C.substring(k))) {
                return 1;
            } else {
                return 0;
            }
        }
        char aTemp = A.charAt(i);
        char bTemp = B.charAt(j);
        char cTemp = C.charAt(k);
        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }
        if (aTemp == cTemp && bTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i + 1, j, k + 1) | recursion(A, B, C, i, j + 1, k + 1);
        } else if (aTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i + 1, j, k + 1);
        } else if (bTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i, j + 1, k + 1);
        } else {
            dpArr[i][j] = 0;
        }
        return dpArr[i][j];
    }
}
