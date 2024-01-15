package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q4_Calculate_Modulo_Negative_Number {
    private static int negativeNumber(int A, int mod) {
        return A - (mod * Math.floorDiv(A, mod));
    }
    public static void main(String[] args) {
        // Calculate -40 % 7
        int A = -40;
        int mod = 7;
        int result = negativeNumber(A, mod);
        // Print the result
        System.out.println(A + " % " + mod + " = " + result);
    }
}
