package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int A) {
        int count = 1;
        for (int i = 2; i <= Math.sqrt(A * 2); i++) {
            int sum = (i * (i - 1)) / 2;
            int x = A - sum;
            if (x % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 15;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
