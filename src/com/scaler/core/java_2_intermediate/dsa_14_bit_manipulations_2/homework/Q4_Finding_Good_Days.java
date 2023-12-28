package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/02/23 11:11 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Finding_Good_Days {
    private static int solve(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 5;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
