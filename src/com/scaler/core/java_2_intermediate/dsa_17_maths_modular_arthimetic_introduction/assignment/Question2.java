package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 28/09/22 2:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(int[] A, int B) {
        long sum = 0;
        long t = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            sum = (sum + A[i] * t) % B;
            t = (t * 10) % B;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 5, 3, 5, 3, 2, 1};
        int B = 47;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
