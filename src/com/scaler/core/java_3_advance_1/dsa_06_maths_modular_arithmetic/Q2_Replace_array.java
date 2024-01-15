package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Q2_Replace_array {
    /**
     * Problem: Given an array A[N]. Where elements are distinct.
     * 0 <= A[i] <= N - 1
     * Replace every array A[i] with A[A[i]]
     * **/
    private static int[] replaceArray(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            A[i] = A[i] * N;
        }
        for (int i = 0; i < N; i++) {
            // A[i] = A[A[i]]
            int index = A[i] / N;
            int value = A[index] / N;
            A[i] = A[i] + value;
        }
        for (int i = 0; i < N; i++) {
            A[i] = A[i] % N;
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {1, 6, 3, 5, 4, 2, 0};
        PrintUtils.print(A);

        int[] results = replaceArray(A);
        PrintUtils.print(results);
    }
}
