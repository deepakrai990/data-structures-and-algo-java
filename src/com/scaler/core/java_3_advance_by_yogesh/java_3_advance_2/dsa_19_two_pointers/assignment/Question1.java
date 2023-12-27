package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers.assignment;

import java.util.Arrays;

/**
 * @created 14/02/23 11:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    public int[] solve(int[] A, int B) {
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
