package com.scaler.core.java_3_advance_2.dsa_22_problems_on_strings_with_hashmaps;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 08/10/23 11:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Period_of_a_String {
    /**
     * Given String has length N, period is defined as minimum K,
     * such that S[i] = S[i % K]
     * Where (K >= 1 for all valid i)
     * Find K.
     * **/
    private static int findPeriodOfAString(String s) {
        int N = s.length();
        int[] lps = computeLPS(s);
        return Math.max(N - lps[N - 1], 0);
    }
    private static int[] computeLPS(String s) {
        int N = s.length();
        int[] lps = new int[N];
        lps[0] = 0;
        for (int i = 1; i < N; i++) {
            // Calculate lps[i]
            int x = lps[ i - 1];
            while (s.charAt(i) != s.charAt(x)) {
                if (x == 0) {
                    x--;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
    public static void main(String[] args) {
        String s = "abcaabcaabc";
        int result = findPeriodOfAString(s);
        PrintUtils.print(result);
    }
}
