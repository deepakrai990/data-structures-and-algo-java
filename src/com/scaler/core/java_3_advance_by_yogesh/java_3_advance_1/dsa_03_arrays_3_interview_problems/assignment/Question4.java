package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment;

/**
 * @created 10/02/23 12:09 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int trap(final int[] A) {
        int units = 0;
        int N = A.length;
        int[] lmax = new int[N];
        lmax[0] = 0;
        int[] rmax = new int[N];
        rmax[A.length - 1] = 0;

        for (int i = 1; i < N; i++) {
            lmax[i] = Math.max(lmax[i - 1], A[i - 1]);
        }

        for (int i = N - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], A[i + 1]);
        }

        for (int i = 1; i < N; i++) {
            int wunit = Math.min(lmax[i], rmax[i]) - A[i];
            if (wunit > 0) {
                units += wunit;
            }
        }

        return units;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        int result = trap(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
