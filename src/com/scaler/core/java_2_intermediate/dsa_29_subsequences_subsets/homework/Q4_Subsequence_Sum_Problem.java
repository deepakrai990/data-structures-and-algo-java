package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 05/03/23 6:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Subsequence_Sum_Problem {
    private static int solve(int[] A, int B) {
        for (int i = 0; i < (1 << A.length); i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sum = sum + A[j];
                }
            }
            if (sum == B) {
                return 1;
            }
        }
        return 0;
    }

    private static int solve_1(int[] A, int B) {
        if (B == 0) return 1;
        int pow = (int) Math.pow(2, A.length);
        for (int i = 0; i < pow; i++) {
            int x = 0;
            int sum = 0;
            int num = i;
            while (num > 0) {
                if ((num & 1) == 1) {
                    sum += A[x];
                }
                x++;
                num = num >> 1;
            }
            if (sum == B) return 1;

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1,20,13,4,5};
        int B = 18;
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve_1(A, B);
        PrintUtils.printInt(result);
    }
}
