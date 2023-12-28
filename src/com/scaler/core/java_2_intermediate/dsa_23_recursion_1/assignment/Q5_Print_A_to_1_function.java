package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.assignment;

/**
 * @created 11/10/22 8:54 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q5_Print_A_to_1_function {
    private static void solve(int A) {
        print(A);
        System.out.println();
    }
    private static void print(int A) {
        if (A <= 0) {
            return;
        }
        System.out.printf("%d ", A);
        print(A - 1);
    }

    public static void main(String[] args) {
        int A = 10;
        solve(A);
    }
}
