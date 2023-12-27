package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.homework;

/**
 * @created 02/04/23 7:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Smallest_Prefix_String {
    private static String smallestPrefix(String A, String B) {
        int i = 1, n = A.length();
        char c = B.charAt(0);
        while (i < n) {
            if(A.charAt(i) >= c)
                break;
            i++;
        }
        String ans = A.substring(0,i) + c;
        return ans;
    }
}
