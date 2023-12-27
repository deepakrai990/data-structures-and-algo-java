package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Minimum_Swaps_2 {
    private static int solve(int[] A) {
        int count = 0;
        int N = A.length;
        int s = 0;
        while (s < N) {
            if (A[s] != s) {
                count++;
                int temp = A[A[s]];
                A[A[s]] = A[s];
                A[s] = temp;
            } else s++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
