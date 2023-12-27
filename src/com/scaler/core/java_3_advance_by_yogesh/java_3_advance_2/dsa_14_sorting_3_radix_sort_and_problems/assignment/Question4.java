package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_14_sorting_3_radix_sort_and_problems.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static int[] solve(int[] A) {
        int n = A.length;
        int max = A[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
        }
        int[] countArray = new int[max];
        for (int i = 0; i < n; i++) {
            countArray[A[i] - 1]++;
        }
        int k = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 1; j <= countArray[i]; j++) {
                A[k++] = i + 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
