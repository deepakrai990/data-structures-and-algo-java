package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/22 6:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Number_of_1_Bits {
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
