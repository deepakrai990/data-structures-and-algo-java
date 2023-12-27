package com.scaler.core.java_3_advance_2.dsa_22_problems_on_strings_with_hashmaps.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 6:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Boring_substring {
    private static int solve(String A) {
        int evenMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        int oddMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;

        int n = A.length();
        for (int i = 0; i < n; i++) {
            int val = (A.charAt(i) - 'a') + 1;
            if (val % 2 == 0) {
                evenMax = Math.max(evenMax, val);
                evenMin = Math.min(evenMin, val);
            } else {
                oddMax = Math.max(oddMax, val);
                oddMin = Math.min(oddMin, val);
            }
        }
        if (Math.abs(evenMax - oddMin) != 1 || Math.abs(oddMax - evenMin) != 1)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "abcd";
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
