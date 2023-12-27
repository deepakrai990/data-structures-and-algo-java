package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:04 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Rain_Water_Trapped {
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
        PrintUtils.print(result);
    }
}
