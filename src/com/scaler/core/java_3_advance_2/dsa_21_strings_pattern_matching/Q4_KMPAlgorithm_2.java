package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

/**
 * @created 07/10/23 11:28 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_KMPAlgorithm_2 {
    private static void searchPattern(String text, String pattern) {
        String concatenatedString = pattern + "$" + text;
        int n = concatenatedString.length();
        int m = pattern.length();
        int[] lps = computeLPS(concatenatedString);
        for (int i = m + 1; i < n; i++) {
            if (lps[i] == m) {
                // Pattern found at index i - 2*m (i.e., the starting index in the original text)
                int startIndex = i - 2 * m;
                System.out.println("Pattern found at index " + startIndex);
            }
        }
    }
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix (LPS)
        lps[0] = 0; // The LPS value for the first character is always 0
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++; lps[i] = len; i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Move the len back to the previous LPS value
                } else {
                    lps[i] = 0; // No matching prefix found, set LPS to 0 and move to the next character
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String text = "ABABABCABABABCABABABC";
        String pattern = "ABAB";
        searchPattern(text, pattern);
    }
}
