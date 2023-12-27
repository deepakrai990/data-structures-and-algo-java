package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Different_Bits_Sum_Pairwise {
    private static int cntBits(int[] A) {
        long ans = 0;
        int n = A.length;
        for (int i = 0; i < 32; i++) {
            long set = 0;
            long unset = 0;
            for (int j : A) {
                if (((j >> i) & 1) == 1) set++;
                else unset++;
            }
            ans += (set * unset) % 1000000007;
            ans %= 1000000007;
        }
        return (int) (ans * 2) % 1000000007;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int result = cntBits(A);
        PrintUtils.print(result);
    }
}
