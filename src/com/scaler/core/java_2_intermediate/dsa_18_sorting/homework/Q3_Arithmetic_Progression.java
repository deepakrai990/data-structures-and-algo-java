package com.scaler.core.java_2_intermediate.dsa_18_sorting.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 20/02/23 1:26 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Arithmetic_Progression {
    private static int solve(int[] A) {
        Arrays.sort(A);
        int result = 1;
        int sum = A[0] - A[1];
        for (int i = 2; i < A.length; i++) {
            if (sum != A[i - 1] - A[i]) {
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]  A = {3, 5, 1};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
