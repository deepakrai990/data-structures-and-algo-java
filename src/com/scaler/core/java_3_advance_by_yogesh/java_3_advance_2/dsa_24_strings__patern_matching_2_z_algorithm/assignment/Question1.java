package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_24_strings__patern_matching_2_z_algorithm.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/02/23 10:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(String A, String B) {
        // concatenate the strings
        B = B + B;
        String p = A + "$" + B;
        int N = p.length();
        // creating lps array
        int[] lps = new int[N];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < N) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // counting the number of occurrences of A.length
        int count = 0;
        for (int j = 0; j < N; j++) {
            if (lps[j] == A.length() && j > 2 * A.length())
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "1001";
        String B = "0011";
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
