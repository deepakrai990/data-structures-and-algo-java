package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets;

/**
 * @author Deepak Kumar Rai
 * @created 09/01/24
 * @project scaler_course_code
 */
public class Q2_Find_sum_of_all_subsequences_sum {
    /**
     * Problem: Given an array A[N] of distinct integers. Find the sum of all subsequence sums.
     * **/
    // Bruteforce Approach
    private static int sumOfSubsequenceSums(int[] A) {
        int n = A.length;
        int totalSum = 0;
        // Iterate through all possible subsequences
        for (int mask = 1; mask < (1 << n); mask++) {
            int currentSum = 0;
            // Check each element in the subsequence
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // Include the element in the current subsequence
                    currentSum += A[i];
                }
            }
            // Add the sum of the current subsequence to the total sum
            totalSum += currentSum;
        }
        return totalSum;
    }
    // Optimise Approach
    private static int sumOfSubsequenceSums1(int[] A) {
        int n = A.length;
        int totalSum = 0;
        // Iterate through all elements in the array
        for (int i = 0; i < n; i++) {
            // Contribution of the current element in all subsequences
            int contribution = (1 << i) * (1 << (n - i - 1)) * A[i];
            // Add the contribution to the total sum
            totalSum += contribution;
        }
        return totalSum;
    }
    public static void main(String[] args) {
        int[] A = {-1, 4, 2};

        int result = sumOfSubsequenceSums(A);
        System.out.println("Sum of all subsequence sums: " + result);

        result = sumOfSubsequenceSums1(A);
        System.out.println("Sum of all subsequence sums: " + result);
    }
}
