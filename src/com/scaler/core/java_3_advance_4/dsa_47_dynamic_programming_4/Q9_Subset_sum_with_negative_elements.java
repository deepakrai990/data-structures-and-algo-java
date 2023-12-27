package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q9_Subset_sum_with_negative_elements {
    /**
     * Problem: Given array A[N] elements.
     * Check if there exists a subset with sum equals to K.
     * Note 1: Element can be picked zero or one times.
     * Note 2: It can have negative numbers (A[] < 0)
     * **/
    // Function to check if there exists a subset with sum equals to K
    private static boolean isSubsetSum(int[] A, int N, int K) {
        // Create a memoization HashMap to store computed results
        HashMap<String, Boolean> memoization = new HashMap<>();
        // Start the recursion from the first element and the target sum K
        return subsetSumRecursive(A, N, K, memoization);
    }
    // Recursive helper function with memoization
    private static boolean subsetSumRecursive(int[] A, int i, int remainingSum, HashMap<String, Boolean> memoization) {
        // Base cases
        if (remainingSum == 0) {
            return true; // Subset with sum K exists
        }
        if (i == 0 || remainingSum < 0) {
            return false; // Subset with sum K does not exist
        }
        // Create a unique key for the current state
        String key = i + ":" + remainingSum;
        // Check if the result is already computed
        if (memoization.containsKey(key)) {
            return memoization.get(key);
        }
        // Include the current element in the subset
        boolean include = subsetSumRecursive(A, i - 1, remainingSum - A[i - 1], memoization);
        // Exclude the current element from the subset
        boolean exclude = subsetSumRecursive(A, i - 1, remainingSum, memoization);
        // Update the memoization HashMap
        memoization.put(key, include || exclude);
        return include || exclude;
    }

    public static void main(String[] args) {
        int[] A = {6, -4, 3, -2, -3, 1, -5};
        int K = 5;

        if (isSubsetSum(A, A.length, K)) {
            System.out.println("Subset with sum " + K + " exists.");
        } else {
            System.out.println("No subset with sum " + K + " exists.");
        }
    }
}
