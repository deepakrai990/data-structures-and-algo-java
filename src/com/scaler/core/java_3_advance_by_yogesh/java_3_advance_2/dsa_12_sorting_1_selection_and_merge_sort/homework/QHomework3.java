package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int[] wave(int[] A) {
        int N = A.length;
        int s = 0;
        int e = N - 1;
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        while (i <= N-2 && j <= N -1) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i += 2;
            j += 2;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] result = wave(A);
        PrintUtils.print1DArray(result);
    }
}
