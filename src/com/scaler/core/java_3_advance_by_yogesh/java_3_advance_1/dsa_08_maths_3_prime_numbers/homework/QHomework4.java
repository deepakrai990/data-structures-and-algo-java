package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 7:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    private static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A >= G || B >= H || C <= E || D <= F)
            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;
        int result = solve(A, B, C, D, E, F, G, H);
        PrintUtils.printInt(result);
    }
}
