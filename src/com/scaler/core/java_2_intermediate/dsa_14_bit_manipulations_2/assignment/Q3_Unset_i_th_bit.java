package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/22 6:42 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Unset_i_th_bit {
    private static int solve(int A, int B) {
        if((A & (1 << B)) == (1 << B)) {
            A = A ^ (1 << B);
        }
        return A;
    }
    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
