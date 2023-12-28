package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.assignment;

/**
 * @created 11/10/22 12:20 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Print_1_to_A_function {
    private static void solve(int A) {
        print(A);
        System.out.println();
    }
    private static void print(int A) {
        if (A <= 0) {
            return;
        }
        print(A - 1);
        System.out.printf("%d ", A);
    }
    public static void main(String[] args) {
        int A = 9;
        solve(A);
    }
}
