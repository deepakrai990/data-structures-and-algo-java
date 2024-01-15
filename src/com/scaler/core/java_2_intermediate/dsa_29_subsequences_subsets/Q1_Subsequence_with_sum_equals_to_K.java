package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets;

/**
 * @created 05/03/23 6:04 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Subsequence_with_sum_equals_to_K {
    /**
     * Problem: Given an array A[N]. Count number subsequence with equals to K
     * **/
    // Approach 2
    private static int countSubsequencesWithSumK(int[] A, int K) {
        int N = A.length, ans = 0;
        for (int i = 0; i < Math.pow(2, N); i++) { // To represent the number of subsequences
            int sum = 0;
            for (int j = 0; j < N; j++) { // To find, the corresponding subsequences
                // Check if jth bit is set in ith number
                if ((i & (1 << j)) != 0) { // Check bit is set or not
                    sum += A[j];
                }
            }
            if (sum == K) {
                ans++;
            }
        }
        return ans;
    }
    // Approach 2
    private static int countSubsequencesWithSumK1(int[] A, int K) {
        int n = A.length;
        int count = 0;
        // Iterate through all possible subsequences
        for (int mask = 0; mask < (1 << n); mask++) {
            int currentSum = 0;
            // Check each element in the subsequence
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // Include the element in the current subsequence
                    currentSum += A[i];
                }
            }

            // Check if the sum is equal to K
            if (currentSum == K) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] A = {-1, 4, 6, 3, 7, 2};
        int K = 10;

        int count = countSubsequencesWithSumK(A, K);
        System.out.println("Number of Subsequences with Sum " + K + ": " + count);

        count = countSubsequencesWithSumK1(A, K);
        System.out.println("Number of Subsequences with Sum " + K + ": " + count);
    }
}
