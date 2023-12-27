package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Number_Of_Open_Doors {
    private static int solve(int A) {
        return (int) Math.floor(Math.sqrt(A));
    }

    public static void main(String[] args) {
        int A = 6;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
