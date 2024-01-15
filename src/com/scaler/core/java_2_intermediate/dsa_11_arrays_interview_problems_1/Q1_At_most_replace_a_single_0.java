package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 27/12/23
 * @project scaler_course_code
 */
public class Q1_At_most_replace_a_single_0 {
    private static int replace(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count = count + A[i];
        }
        if (count == N) { // Edge Case 1
            return N;
        }
        if (count == 0) { // dge Case 2
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                int left = 0, right = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] == 1) {
                        left++;
                    } else {
                        break;
                    }
                }
                for (int j = i + 1; j < N; j++) {
                    if (A[i] == 1) {
                        right++;
                    } else {
                        break;
                    }
                }
                int countElements = left + right + 1;
                if (countElements > ans) {
                    ans = countElements;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1};
        int N = A.length;

        int result = replace(A, N);
        PrintUtils.print(result);
    }
}
