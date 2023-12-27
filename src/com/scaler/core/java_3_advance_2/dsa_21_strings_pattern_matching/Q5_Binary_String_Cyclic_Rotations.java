package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

/**
 * @created 07/10/23 11:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Binary_String_Cyclic_Rotations {
    /**
     * Given a binary string. Find no of start-end cyclic rotations
     * which are the same as the given string.
     * **/
    private static int countCyclicRotations(String binaryString) {
        int n = binaryString.length();
        String concatenatedString = binaryString + "$" + binaryString + binaryString;
        int[] lps = computeLPS(concatenatedString);
        int countOccurrence = 0;
        for (int i = 0; i < lps.length; i++) {
            if (n == lps[i]) countOccurrence++;
        }
        return countOccurrence - 1;
    }
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix (LPS)
        lps[0] = 0; // The LPS value for the first character is always 0
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1]; // Move the len back to the previous LPS value
                else {
                    lps[i] = 0; // No matching prefix found, set LPS to 0 and move to the next character
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String binaryString = "1010";
        int rotations = countCyclicRotations(binaryString);
        System.out.println("Number of cyclic rotations: " + rotations);
    }
}
