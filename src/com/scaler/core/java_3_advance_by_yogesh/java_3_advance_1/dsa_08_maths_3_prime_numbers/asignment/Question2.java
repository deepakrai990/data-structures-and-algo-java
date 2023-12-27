package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers.asignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/01/23 11:27 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(int A) {
        return (int) Math.floor(Math.sqrt(A));
    }

    public static void main(String[] args) {
        int A = 6;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
