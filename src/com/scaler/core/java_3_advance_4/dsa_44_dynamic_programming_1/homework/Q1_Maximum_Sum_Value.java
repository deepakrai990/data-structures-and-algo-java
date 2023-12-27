package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.homework;

/**
 * @created 02/04/23 10:24 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Maximum_Sum_Value {
    private static int solve(int[] A, int B, int C, int D) {
        int[] mul = {B, C, D};
        int[][] tab = new int[A.length][mul.length + 1];
        int max = 0;
        for (int i = 0; i < tab.length; i++) tab[i][tab[0].length - 1] = 0;
        for (int j = mul.length - 1; j >= 0; j--) {
            max = Integer.MIN_VALUE;
            for (int i = tab.length - 1; i >= 0; i--) {
                max = Math.max(max, tab[i][j + 1]);
                tab[i][j] = max + (A[i] * mul[j]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < tab.length; i++) res = Math.max(res, tab[i][0]);
        return res;
    }
}
