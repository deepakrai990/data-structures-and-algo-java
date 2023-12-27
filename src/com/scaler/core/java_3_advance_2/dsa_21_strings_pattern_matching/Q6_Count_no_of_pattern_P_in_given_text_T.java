package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

/**
 * @created 08/10/23 10:49 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Count_no_of_pattern_P_in_given_text_T {
    /**
     * Count no of pattern P in given text T
     * **/
    private static int countPatternOccurrences(String text, String pattern) {
        String concatenatedString = pattern + "$" + text;
        int n = concatenatedString.length();
        int m = pattern.length();
        int[] lps = computeLPS(concatenatedString);
        int count = 0;
        int i = 0; // Index for concatenatedString[]
        int j = 0; // Index for a pattern[]
        while (i < n) {
            if (pattern.charAt(j) == concatenatedString.charAt(i)) {
                i++; j++;
            }
            if (j == m) {
                count++; // Pattern found at index i - j
                j = lps[j - 1]; // Update j based on LPS array
            } else if (i < n && pattern.charAt(j) != concatenatedString.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Mismatch after some matching characters, update j based on LPS array
                } else {
                    i++; // Mismatch at the beginning of the pattern, move to the next character in concatenatedString
                }
            }
        }
        return count;
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
        String text = "ABABABABABA";
        String pattern = "ABA";
        int count = countPatternOccurrences(text, pattern);
        System.out.println("Number of pattern occurrences: " + count);
    }
}
