package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

/**
 * @created 08/10/23 9:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q8_Z_algorithm {
    //  prints all occurrences of pattern in text using
    // Z algo
    public static void find(String text, String pattern) {
        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int l = concat.length();

        int[] Z = new int[l];
        // Construct the Z array
        createZArray(concat, Z);
        // now looping through the Z array for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index "
                        + (i - pattern.length() - 1));
            }
        }
    }
    // Fills Z array for given string str[]
    private static void createZArray(String str, int[] Z) {
        int n = str.length();
        // [left,right] make a window which matches with
        // prefix of s
        int left = 0, right = 0;
        for (int i = 1; i < n; ++i) {
            // if i > right nothing matches, so we will calculate.
            // Z[i] using naive way.
            if (i > right) {
                left = right = i;
                while (right < n && str.charAt(right - left) == str.charAt(right))
                    right++;
                Z[i] = right - left;
                right--;
            } else {
                // k = i - left, so k corresponds to the number which
                // matches in the [left, right] interval.
                int k = i - left;
                if (Z[k] < right - i + 1)
                    Z[i] = Z[k];
                else {
                    // else start from the right and check manually
                    left = i;
                    while (right < n && str.charAt(right - left) == str.charAt(right))
                        right++;
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "faabbcdeffghiaaabbcdfgaabf";
        String pattern = "aabb";
        find(text, pattern);
    }
}
