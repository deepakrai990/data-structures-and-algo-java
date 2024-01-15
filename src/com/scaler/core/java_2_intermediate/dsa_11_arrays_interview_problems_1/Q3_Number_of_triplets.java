package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 03/01/24
 * @project scaler_course_code
 */
public class Q3_Number_of_triplets {
    private static int countTriplets(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (A[i] < A[j] && A[j] < A[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    // Optimise One
    private static int countTriplets1(int[] A, int N) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int left = 0, right = 0;
            // Check left for elements less than A[i]
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    left++;
                }
            }
            // Check on right for elements mor than A[i]
            for (int j = i + 1; j < N; j++) {
                if (A[i] < A[j]) {
                    right++;
                }
            }
            int count = left * right; // Multiply here
            ans = ans + count;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {4, 1, 2, 6, 9, 7};
        int N = A.length;

        int result = countTriplets(A, N);
        PrintUtils.print(result);

        result = countTriplets1(A, N);
        PrintUtils.print(result);
    }
}
