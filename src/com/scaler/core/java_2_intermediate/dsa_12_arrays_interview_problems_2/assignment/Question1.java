package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2.assignment;

import java.util.Arrays;

/**
 * @created 17/09/22 9:18 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Sum of odd indices
     * <p>
     * Problem Description
     * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
     * For every query, the task is to calculate the sum of all odd indices in the range A[B[i][0]…B[i][1]].
     * <p>
     * Note : Use 0-based indexing
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= Q <= 105
     * 1 <= A[i] <= 100
     * 0 <= B[i][0] <= B[i][1] < N
     * <p>
     * <p>
     * Input Format
     * First argument A is an array of integers.
     * Second argument B is a 2D array of integers.
     * <p>
     * <p>
     * Output Format
     * Return an array of integers.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0,2]
     * [1,4]   ]
     * Input 2:
     * A = [2, 1, 8, 3, 9]
     * B = [   [0,3]
     * [2,4]   ]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * [2, 6]
     * Output 2:
     * [4, 3]
     * <p>
     * <p>
     * Example Explanation
     * For Input 1:
     * The subarray for the first query is [1, 2, 3] whose sum of odd indices is 2.
     * The subarray for the second query is [2, 3, 4, 5] whose sum of odd indices is 6.
     * For Input 2:
     * The subarray for the first query is [2, 1, 8, 3] whose sum of odd indices is 4.
     * The subarray for the second query is [8, 3, 9] whose sum of odd indices is 3.
     **/
    private static int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int[] oddPrefixSum = new int[N];
        oddPrefixSum[0] = 0;
        for (int i = 1; i < N; i++) {
            if (i % 2 == 0) {
                oddPrefixSum[i] = oddPrefixSum[i - 1];
            } else {
                oddPrefixSum[i] = oddPrefixSum[i - 1] + A[i];
            }
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int sum = 0;
            if (L == 0) sum = oddPrefixSum[R];
            else sum = oddPrefixSum[R] - oddPrefixSum[L - 1];
            ans[i] = sum;
        }
        return ans;
    }

    /**
     * Solution from scaler
     **/
    private static int[] solve1(int[] A, int[][] B) {
        int n = A.length;
        int[] pref = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                pref[i] = pref[i - 1] + A[i];
            } else {
                pref[i] = pref[i - 1];
            }
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int val = pref[B[i][1]];
            if (B[i][0] > 0) {
                val -= pref[B[i][0] - 1];
            }
            ans[i] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 2}, {1, 4}};
        int[] result = solve(A, B);
        System.out.println(Arrays.toString(result));
        result = solve1(A, B);
        System.out.println(Arrays.toString(result));
    }
}
