package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:58 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Number_of_1_Bits {
    private static int numSetBits(int A) {
        int count = 0;
        while(A > 0) {
            count += A & 1;
            A >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int A = 11;
        int result = numSetBits(A);
        PrintUtils.printInt(result);
    }
}
