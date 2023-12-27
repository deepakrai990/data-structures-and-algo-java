package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 21/12/23
 * @project scaler_course_code
 */
public class Q3_Regex_Matching_1 {
    /**
     * Problem: Regex-Matching
     * Given text (T) and pattern (P) check if both are same or not
     * T -> In text it contains only alphabets
     * P -> With alphabets it contains.
     *      ? -> It can match any One char
     *      * -> it can match any number of chars >= 0
     * **/
    static int[][] DP;
    private static int solve(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        DP = new int[N][M];
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return regex(text, pattern, N - 1, M - 1);
    }
    private static int regex(String text, String pattern, int i, int j) {
        if (i < 0 && j < 0) {
            return 1;
        } else if (i < 0) {
            for (int k = 0; k < j; k++) {
                if (pattern.charAt(k) != '*'){
                    return 0;
                }
            }
            return 1;
        } else if (j < 0) {
            return 0;
        }
        if (DP[i][j] == -1) { // Called for 1st time
            if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
                DP[i][j] = regex(text, pattern, i - 1, j - 1);
            } else if (pattern.charAt(j) == '*') { // Star: skip it or match 1 char and stay
                DP[i][j] = regex(text, pattern, i, j - 1) | regex(text, pattern, i - 1, j);
                //---------------------skip------------------------------match and stay---------
            } else { // No match
                DP[i][j] = 0;
            }
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        String text = "ant";
        String pattern = "a?**t";
        int result = solve(text, pattern);
        PrintUtils.print(result);
    }
}
