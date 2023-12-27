package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.assignment;

/**
 * @created 02/04/23 6:59 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Cyclic_Permutations {
    private static int solve(String A, String B) {
        int count = 0;
        int patternLen = A.length();
        String patternString = A + "$" + B + B.substring(0, B.length() - 1);
        int[] LPS = computeLPS(patternString);
        int lpsLen = LPS.length;

        for (int i = patternLen; i < lpsLen; i++) {
            if (LPS[i] == patternLen) {
                count++;
            }
        }

        return count;
    }

    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] LPS = new int[n];
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];

            while (str.charAt(i) != str.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        return LPS;
    }
}
