package com.scaler.core.java_2_intermediate.dsa_18_sorting.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 29/09/22 9:45 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Noble_Integer {
    private static int solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);

        if (A[n - 1] == 0)
            return 1;

        for (int i = 0; i < n - 1; i++) {
            if (A[i] != A[i + 1] && A[i] == n - i - 1)
                return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 3};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
