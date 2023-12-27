package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 10:15 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Fractional_Knapsack {
    private static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        double[][] pair = new double[n][3];
        for (int i = 0; i < n; i++) {
            pair[i][0] = (double) A[i];
            pair[i][1] = (double) B[i];
            pair[i][2] = (double) A[i] / B[i];
        }

        Arrays.sort(pair, (a, b) -> Double.compare(b[2], a[2]));
        double sum = 0;
        double remainingCapacity = (double) C;
        for (int i = 0; i < n; i++) {
            if (pair[i][1] <= remainingCapacity) {
                sum += pair[i][0];
                remainingCapacity -= pair[i][1];
            } else {
                sum = (sum * 100) + (remainingCapacity * pair[i][2]) * 100;
                return (int) sum;
            }

        }
        return (int) sum * 100;
    }
}
