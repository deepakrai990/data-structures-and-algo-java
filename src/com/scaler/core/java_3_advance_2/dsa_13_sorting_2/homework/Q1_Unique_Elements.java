package com.scaler.core.java_3_advance_2.dsa_13_sorting_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 7:30 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Unique_Elements {
    private static int solve(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (A[i - 1] >= A[i]) {
                count += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 3};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
