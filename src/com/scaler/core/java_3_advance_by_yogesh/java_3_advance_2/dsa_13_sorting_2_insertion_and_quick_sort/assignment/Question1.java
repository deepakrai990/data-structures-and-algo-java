package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_13_sorting_2_insertion_and_quick_sort.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
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
