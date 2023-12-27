package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/22 6:46 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static int solve(int A, int B) {
        int num = (1 << A);
        if(A != B){
            num = num + (1 << B);
        }
        return num;
    }
    public static void main(String[] args) {
        int A = 3;
        int B = 5;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
