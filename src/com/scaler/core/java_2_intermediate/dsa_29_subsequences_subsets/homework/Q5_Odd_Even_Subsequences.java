package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 05/03/23 6:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Odd_Even_Subsequences {
    private static int solve(int[] A) {
        int n = A.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if ((A[i - 1] & 1) != (A[i] & 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]  A = {1, 2, 2, 5, 6};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
