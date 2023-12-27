package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 18/01/23 10:43 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 12;
        int result = cpFact(A, B);
        PrintUtils.printInt(result);
    }
}
