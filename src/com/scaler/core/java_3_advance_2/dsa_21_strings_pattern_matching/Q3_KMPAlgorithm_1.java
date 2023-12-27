package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

/**
 * @created 07/10/23 11:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_KMPAlgorithm_1 {
    private static void KMP(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPS(pattern);
        int i = 0; // Index for text[]
        int j = 0; // Index for a pattern[]
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++; j++;
            }
            if (j == m) {
                // Pattern found at index i - j
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // Update j based on LPS array
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Mismatch after some matching characters, update j based on LPS array
                } else {
                    i++; // Mismatch at the beginning of the pattern, move to the next character in text
                }
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
        KMP(text, pattern);
    }
}
