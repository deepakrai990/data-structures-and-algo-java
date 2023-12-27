package com.scaler.core.java_3_advance_2.dsa_20_hashing_2.assignment;

/**
 * @created 02/04/23 7:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Replicating_Substring {
    private static int solve(int A, String B) {
        int[] freq = new int[26];
        for (int i = 0; i < B.length(); i++) {
            freq[B.charAt(i) - 'a'] += 1;
        }

        for (int val : freq) {
            if (val % A != 0) {
                return -1;
            }
        }
        return 1;
    }
}
