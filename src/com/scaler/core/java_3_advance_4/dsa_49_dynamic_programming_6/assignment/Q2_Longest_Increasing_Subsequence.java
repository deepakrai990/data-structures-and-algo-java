package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.assignment;

/**
 * @created 02/04/23 9:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Longest_Increasing_Subsequence {
    public int lis(final int[] A) {
        int n = A.length;
        int[] minLength = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i])
                    minLength[i] = Math.max(minLength[i], minLength[j] + 1);
            }
        }

        int maxLength = 0;
        for (int l : minLength) //every dp state can be possible answer
            maxLength = Math.max(maxLength, l);
        return maxLength + 1;
    }
}
