package com.scaler.core.java_3_advance_2.dsa_22_problems_on_strings_with_hashmaps;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_LPSArrayOptimise {
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
        String s = "abadabac";
        int[] results = computeLPS(s);
        PrintUtils.print(results);
    }
}
