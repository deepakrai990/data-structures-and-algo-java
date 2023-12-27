package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 11:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Finish_Maximum_Jobs {
    private static int solve(int[] A, int[] B) {
        int n = A.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i] = new int[]{A[i], B[i]};
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int endTime = pair[0][1];
        for (int i = 1; i < n; i++) {
            if (pair[i][0] >= endTime) {//escaping conflicts
                endTime = pair[i][1];
                count++;
            }
        }
        return count;
    }
}
