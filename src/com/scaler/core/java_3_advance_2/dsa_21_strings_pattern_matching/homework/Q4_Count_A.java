package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.homework;

/**
 * @created 02/04/23 7:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Count_A {
    private static int solve(String A) {
        int N = A.length();
        int total_count = 0;
        int count_a = 0;

        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == 'a') {
                count_a++;
                total_count += count_a;
            }
        }
        return total_count;
    }
}
