package com.scaler.core.java_2_intermediate.dsa_16_contest_1_discussion_class;

/**
 * @created 26/09/22 7:06 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(int A, int B) {
        int binaryNumber = 0;
        for (int i = B; i < (A + B) - 1; i++) {
            binaryNumber += 1L * (1 << i);
        }
        return binaryNumber;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 2;
        int result = solve(A, B);
        System.out.println("Result : " + result);
    }
}
