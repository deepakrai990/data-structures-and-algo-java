package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int[] solve(int[] A) {
        Arrays.sort(A);
        int j = A.length - 1;
        long max = 0, min = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length / 2; i++) {
            max += Math.abs(A[j] - A[i]);
            max %= mod;
            j--;
        }

        for (j = A.length - 1; j >= 0; j -= 2) {
            min += Math.abs(A[j] - A[j - 1]);
            min %= mod;
        }

        int[] B = new int[]{(int) max, (int) min};
        return B;
    }

    public static void main(String[] args) {
        int[] A = {3, 11, -1, 5};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
