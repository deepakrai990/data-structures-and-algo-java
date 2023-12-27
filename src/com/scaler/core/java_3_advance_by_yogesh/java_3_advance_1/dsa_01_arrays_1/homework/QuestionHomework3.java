package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1.homework;

/**
 * @created 04/01/23 5:31 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3 {
    private static int solve(int[] A, int[] B, int[] C, int[] D) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 16; i++) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < A.length; j++) {
                int sum = A[j];
                int tmp = 0;

                for (int m = 0; m < 4; m++) {
                    if (m == 0) {
                        tmp = B[j];
                    } else if (m == 1) {
                        tmp = C[j];
                    } else if (m == 2) {
                        tmp = D[j];
                    } else {
                        tmp = j;
                    }
                    if ((i & (1 << m)) != 0) {
                        sum += tmp;
                    } else {
                        sum -= tmp;
                    }
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
            maxSum = Math.max(maxSum, Math.abs(max - min));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = {-1, 4, 5, 6};
        int[] C = {-10, 5, 3, -8};
        int[] D = {-1, -9, -6, -10};
        int result = solve(A, B, C, D);
        System.out.println("Result: " + result);
    }
}
