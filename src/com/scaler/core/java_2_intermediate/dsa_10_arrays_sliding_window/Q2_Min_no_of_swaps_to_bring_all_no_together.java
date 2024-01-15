package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 03/01/24
 * @project scaler_course_code
 */
public class Q2_Min_no_of_swaps_to_bring_all_no_together {
    private static int solve(int[] A, int N, int B) {
        int count = 0;
        // Count of good elements
        for (int i = 0; i < N; i++) {
            if (A[i] <= B) {
                count++;
            }
        }
        if (count <= 1) {
            return 0;
        }
        int badElements = 0;
        // Get number of bad elements in first window
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                badElements++;
            }
        }
        int ans = badElements;
        int start = 1, end = count;
        while (end < N) {
            if (A[start - 1] > B) { // Out going
                badElements--;
            }
            if (A[end] > B) { // In coming
                badElements++;
            }
            ans = Math.min(ans, badElements);
            start++;
            end++;
        }
        return ans;
    }
    public static void main(String[] args) {int[] A = {8, 3, 10, 20, 22, 13, 1, 2, 55, 5, 15, 50};
        int B = 5, N = A.length;

        int result = solve(A, N, B);
        PrintUtils.print(result);
    }
}
