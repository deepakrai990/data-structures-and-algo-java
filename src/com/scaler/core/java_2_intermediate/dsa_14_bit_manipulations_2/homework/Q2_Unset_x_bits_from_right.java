package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/22 6:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Unset_x_bits_from_right {
    private static long solve(long A, int B) {
        return A & (Long.MAX_VALUE << B);
    }

    public static void main(String[] args) {
        long A = 25l;
        int B = 3;
        long result = solve(A, B);
        PrintUtils.printLong(result);
    }
}
