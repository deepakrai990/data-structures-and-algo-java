package com.scaler.core.java_3_advance_2.dsa_11_recursion_2.homework;

/**
 * @author Deepak Kumar Rai
 * @created 02/04/23 7:38 pm
 * @project scaler_course_code
 */
public class Q1_Kth_Symbol {
    private static int solve(int A, int B) {
        return solveQ(A, B) ? 1 : 0;
    }

    private static boolean solveQ(int n, int k) {
        if (n == 1 && k == 1)
            return false;
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k <= mid)
            return solveQ(n - 1, k);
        else
            return !solveQ(n - 1, k - mid);
    }

    public static void main(String[] args) {

    }

}
