package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 28/09/22 2:50 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int A, int B, int C) {
        if (A % C != A) {
            int temp = C;
            C = A;
            A = temp;
        }
        if (B % C != B) {
            int temp = C;
            C = B;
            B = temp;
        }
        if (A % B != A) {
            int temp = B;
            B = A;
            A = temp;
        }
        return A * 10000 + B * 100 + C;
    }

    public static void main(String[] args) {
        int A = 55;
        int B = 43;
        int C = 47;
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
