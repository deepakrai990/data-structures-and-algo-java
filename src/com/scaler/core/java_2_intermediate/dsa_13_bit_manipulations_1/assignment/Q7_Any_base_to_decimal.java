package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/09/22 11:43 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q7_Any_base_to_decimal {
    private static int solve(int A, int B) {
        int multiplier = 0, ans_num = 0;
        while (A > 0) {
            int remainder = A % 10;
            A = A / 10;
            ans_num += remainder * Math.pow(B, multiplier);
            multiplier++;
        }
        return ans_num;
    }

    public static void main(String[] args) {
        int A = 1010;
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
