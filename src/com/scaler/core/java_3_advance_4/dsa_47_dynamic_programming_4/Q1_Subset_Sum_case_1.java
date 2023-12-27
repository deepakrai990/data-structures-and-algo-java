package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Subset_Sum_case_1 {
    /**
     * Problem: Subset Sum
     * Case 1: Element is picked zero or one (0/1)
     *      A. Sum possible
     *      B. # ways to get Sum
     *      C. Minimum elements
     * Given A[N] elements.
     * Check is there exists a subset with sum equals to K.
     * All elements are positive (+ive).
     * Note 1: Every element can be picked at most once.
     * **/
    static int[][] DP;
    private static int isSubsetSum(int[] A, int N, int K) {
        // Create a memoization table to store computed results
        DP = new int[N + 1][K + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }
        // Start the recursion from the first element and the target sum K
        return subsetSum(A, N, K);
    }
    private static int subsetSum(int[] A, int i, int j) {
        if (i < 0) { // No elements
            if (j == 0)
                return 1; // We can get sum = 0 with no elements
            else
                return 0;
        }
        if (DP[i][j] == -1) { // Called for 1st time
            int a = subsetSum(A, i - 1, j); // Not picked
            int b = 0;
            if (j >= A[i]) {
                b = subsetSum(A, i - 1, j - A[i]); // Picked
            }
            DP[i][j] = a | b;
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int[] A = {7, 4, 9, 6, 10, 13, 14, 11};
        int K = 26;
        int result = isSubsetSum(A, A.length - 1, K);
        PrintUtils.print(result);
    }
}
