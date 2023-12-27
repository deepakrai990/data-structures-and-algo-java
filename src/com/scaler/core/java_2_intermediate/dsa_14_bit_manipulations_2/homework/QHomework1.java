package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/22 6:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int A, int B) {
        return A ^ (1 << B);
    }
    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
