package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:04 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Minimum_number_of_jumps {
    private static int solve(int[] A) {
        int Step = 0, Pos = 0, Max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > Pos) return -1;
            if (Pos >= A.length - 1) return Step;
            Max = Math.max(Max, (i + A[i]));
            if (i == Pos) {
                Step += 1;
                Pos = Max;
            }
        }
        return Pos;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
