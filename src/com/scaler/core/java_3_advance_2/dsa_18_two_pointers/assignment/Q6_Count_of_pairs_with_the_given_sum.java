package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.assignment;

/**
 * @created 02/04/23 7:11 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Count_of_pairs_with_the_given_sum {
    private static int solve(int[] A, int B) {
        int i = 0;
        int j = A.length - 1;
        int count = 0;

        while (i < j) {
            int sum = A[i] + A[j];
            if (sum == B) {
                count++;
                i++;
                j--;
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
