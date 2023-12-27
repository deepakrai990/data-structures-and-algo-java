package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    private static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || G <= A || D <= F || H <= B) {
            return 0;
        } else {
            int width = Math.min(C, G) - Math.max(A, E);
            int height = Math.min(H, D) - Math.max(B, F);
            return width * height;
        }
    }

    public static void main(String[] args) {
        int A = 0,   B = 0, C = 4,   D = 4, E = 2,   F = 2, G = 6,   H = 6;
        int result = solve(A, B, C, D, E, F, G, H);
        PrintUtils.printInt(result);
    }
}
