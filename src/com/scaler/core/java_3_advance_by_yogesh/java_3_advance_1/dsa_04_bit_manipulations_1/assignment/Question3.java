package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

/**
 * @created 10/02/23 8:13 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(int[] A) {
        long xorSum = 0;
        int mod = 1000000007;

        for (int i = 0; i < 32; i++) {
            long cntSet = 0;
            long cntUnset = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    cntSet++;
                } else {
                    cntUnset++;
                }
            }
            long pairs = cntSet * cntUnset;
            xorSum += pairs * (1 << i);
            xorSum = xorSum % mod;
        }
        return (int) xorSum % mod;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 2};
        int result = solve(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
