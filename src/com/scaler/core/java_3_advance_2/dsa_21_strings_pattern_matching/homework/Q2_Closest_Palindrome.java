package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.homework;

/**
 * @created 02/04/23 7:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Closest_Palindrome {
    private static String solve(String A) {
        int start = 0;
        int end = A.length() - 1;
        int ans = 0;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                ans += 1;
            }
            start += 1;
            end -= 1;
        }
        return (ans == 0 && A.length() % 2 == 1) || (ans == 1) ? "YES" : "NO";
    }
}
