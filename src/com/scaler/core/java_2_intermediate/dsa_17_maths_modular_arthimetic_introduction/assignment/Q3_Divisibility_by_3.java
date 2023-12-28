package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 28/09/22 2:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Divisibility_by_3 {
    private static int solve(int[] A) {
        long sum = 0l;
        long t = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            sum = (sum + A[i] * t) % 3;
            t = (t * 10) % 3;
        }
        if (sum % 3 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 1, 2};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
