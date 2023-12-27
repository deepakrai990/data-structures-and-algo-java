package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 28/09/22 2:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int A, int B, int C) {
        long ans = 1;
        for (int i = 1; i <= B; i++) {
            ans = (ans * A) % C;
        }
        return (int) (ans % C);
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 3;
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
