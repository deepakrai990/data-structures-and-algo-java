package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/10/22 8:41 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Find_Factorial {
    private static int solve(int A) {
        if (A == 1) {
            return 1;
        } else {
            return A * solve(A - 1);
        }
    }

    public static void main(String[] args) {
        int A = 4;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
