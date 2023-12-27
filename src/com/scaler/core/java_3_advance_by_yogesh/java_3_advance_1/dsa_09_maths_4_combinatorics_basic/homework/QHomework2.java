package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int titleToNumber(String A) {
        int N = A.length();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (N == 1) {
                ans = ans + (int) A.charAt(i) - 64;
            } else {
                ans = ans + (int) Math.pow(26, N - 1 - i) * (A.charAt(i) - 64);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "AB";
        int result = titleToNumber(A);
        PrintUtils.printInt(result);
    }
}
