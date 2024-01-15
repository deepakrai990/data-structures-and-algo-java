package com.scaler.core.java_3_advance_1.dsa_01_arrays_1;

/**
 * @author Deepak Kumar Rai
 * @created 09/01/24
 * @project scaler_course_code
 */
public class Q4_Find_Max_Sum_Subarray {
    /**
     * Problem: Kadane's algorithm
     * Given array A[N]. Find max sum of subarray.
     * **/
    // Approach 1
    private static int maxSubarraySum(int[] A) {
        int N = A.length, sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum = sum + A[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
    // Approach 2
    private static int maxSubarraySum1(int[] A) {
        int n = A.length;
        int maxEndingHere = A[0];
        int maxSoFar = A[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        int[] A = {5, 6, 7, -3, 2, -10, -12, 8, 12, 21, -4, 7}; // {3, 2, -6, 8, 2, 9, 4};

        int maxSum = maxSubarraySum(A);
        System.out.println("Max Sum of Subarray: " + maxSum);

        maxSum = maxSubarraySum1(A);
        System.out.println("Max Sum of Subarray: " + maxSum);
    }
}
