package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q3_Q2_Noble_Integers_Repeating {
    private static int countNobleIntegersRepeat(int[] A) {
        int N = A.length, less = 0, nobleCount = 0;
        Arrays.sort(A);
        if (A[0] == 0) { // Edge case
            nobleCount++;;
        }
        for (int i = 1; i < N; i++) {
            // For A[i], get elements < A[i]
            if (A[i] != A[i - 1]) {
                less = i;
            }
            if (less == A[i]) {
                nobleCount++;
            }
        }
        return nobleCount;
    }
    public static void main(String[] args) {
        int[] A = {-3, 0, 2, 2, 5, 5, 5, 5, 8, 8, 10, 10, 14};

        int nobleCount = countNobleIntegersRepeat(A);
        System.out.println("Number of Noble Integers: " + nobleCount);
    }
}
