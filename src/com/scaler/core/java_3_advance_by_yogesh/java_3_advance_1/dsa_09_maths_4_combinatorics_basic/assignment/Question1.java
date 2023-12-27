package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int A, int B, int C) {
        int[] prev = new int[B + 1];
        int[] curr = new int[B + 1];
        prev[0] = 1;
        curr[0] = 1;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                curr[j] = (prev[j] + prev[j - 1]) % C;
            }
            prev = curr.clone();
        }
        return curr[B];
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int C = 13;
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
