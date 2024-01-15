package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @author Deepak Kumar Rai
 * @created 21/09/22 3:58 pm
 * @project Scaler_Beginners_Module
 */
public class Q1_XOR_Sum {
    private static int solve(int A, int B) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            if (((1 << i) & A) != ((1 << i) & B)) {
                res |= (1 << i);
            }
        }
        return res;
    }

    private static int solve1(int A, int B) {
        return A ^ B;
    }

    public static void main(String[] args) {
        int A = 6;
        int B = 12;
        int result = solve(A, B);
        System.out.println("Result " + result);
        result = solve1(A, B);
        System.out.println("Result " + result);
    }
}
