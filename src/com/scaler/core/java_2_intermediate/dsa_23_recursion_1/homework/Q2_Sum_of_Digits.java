package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.homework;

/**
 * @created 11/10/22 8:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Sum_of_Digits {
    private static int solve(int A) {
        if (A == 0) {
            return 0;
        }
        int rem = A % 10;
        A /= 10;
        return rem + solve(A);
    }
    public static void main(String[] args) {
        int A = 46;
        int result = solve(A);
        System.out.println("Result : " + result);
    }
}
