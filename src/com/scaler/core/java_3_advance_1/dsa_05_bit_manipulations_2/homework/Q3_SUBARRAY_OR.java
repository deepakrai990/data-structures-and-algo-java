package com.scaler.core.java_3_advance_1.dsa_05_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:56 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_SUBARRAY_OR {
    private static int solve(int[] A) {
        long ans = 0L;
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        for (int i = 0; i < 32; i++) {
            long anszero = 0L;
            long cnt = 0L;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) != 1) {
                    cnt++;
                } else {
                    anszero += ((cnt * (cnt + 1)) / 2);
                    cnt = 0;
                }
            }
            anszero += ((cnt * (cnt + 1)) / 2);
            anszero = (tot_subArray - anszero);
            ans = (ans + (anszero * (1 << i))) % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
