package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.assignment;

/**
 * @created 17/01/23 11:24 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int A = 8;
        int B = 24;
        int result = gcd(A, B);
        System.out.println("Result : " + result);
    }
}
