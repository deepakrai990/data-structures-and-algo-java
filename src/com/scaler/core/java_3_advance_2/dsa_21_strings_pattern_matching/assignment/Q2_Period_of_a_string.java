package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 6:59 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Period_of_a_string {
    private static int solve(String A) {
        int n = A.length();
        int[] LPS = new int[n];
        LPS[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];
            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        int k = n - LPS[n - 1];
        return k;
    }

    public static void main(String[] args) {
        String A = "abababab";
        int result = solve(A);
        PrintUtils.print(result);
    }
}
