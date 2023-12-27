package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 7:09 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Subarray_with_given_sum {
    private static int[] solve(int[] A, int B) {
        int n = A.length;
        int sum = A[0];

        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (sum < B) {
                j++;
                if (j < n)
                    sum += A[j];
            } else if (sum == B) {
                return Arrays.copyOfRange(A, i, j + 1);
            } else {
                sum -= A[i];
                i++;
            }
        }
        return new int[]{-1};
    }
}
