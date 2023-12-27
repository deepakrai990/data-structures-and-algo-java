package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 14/09/22 1:59 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int k = B;
        // Initialize beginning index of result
        int res_index = 0;
        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += A[i];

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;
        // Traverse from (k+1)'th element to n'th element
        for (int i = k; i < n; i++) {
            // Add current item and remove first
            // item of previous subarray
            curr_sum += A[i] - A[i - k];

            // Update result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = (i - k + 1);
            }
        }
        return res_index;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 5, 20, -10, 0, 12};
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
