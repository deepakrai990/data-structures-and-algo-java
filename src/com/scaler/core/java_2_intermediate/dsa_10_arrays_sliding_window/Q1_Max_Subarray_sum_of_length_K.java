package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 27/12/23
 * @project scaler_course_code
 */
public class Q1_Max_Subarray_sum_of_length_K {
    private static int subarraySum(int[] A, int N, int K) {
        int sum = 0;
        // Calculate sum 0 to K
        for (int i = 0; i < K; i++) {
            sum += A[i];
        }
        int ans = sum;
        int start = 1, end = K;
        // Calculate: A[start - 1] + A[end]
        // Calculate: A[0] + A[5]
        // Calculate: A[1] + A[6]
        // Calculate: A[2] + A[7]
        // Calculate: A[3] + A[8]
        // and so on...
        while (end < N) {
            sum = sum - A[start - 1] + A[end];
            ans = Math.max(ans, sum);
            start++;
            end++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int N = A.length;
        int K = 5;
        int result = subarraySum(A, N, K);
        PrintUtils.print(result);
    }
}
