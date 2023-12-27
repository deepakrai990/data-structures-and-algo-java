package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 07/10/23 10:59 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Calculate_LPS_Array_of_a_given_string {
    /**
     * Calculate the LPS array of a given string
     * **/
    private static int[] calculateLPS(String pattern) {
        int N = pattern.length();
        int[] lps = new int[N];
        int len = 0; // Length of the previous longest prefix suffix
        // Initialize lps[0] as 0, as there is no proper prefix and suffix
        lps[0] = 0;
        int i = 1;
        while (i < N) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // If not at the start, set len to the previous LPS value
                    len = lps[len - 1];
                } else {
                    // If at the start and no match, set lps[i] to 0 and move to the next character
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String pattern = "aabacaaba";
        int[] lps = calculateLPS(pattern);
        PrintUtils.print(lps);
    }
}
