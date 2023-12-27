package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Knapsack_1 {
    /**
     * Problem: Knapsack
     * Given N items each with a weight and value.
     * Find the maximum value which can be obtained by picking items such that
     * total weight of all items less than or equals to (<=) K. K has given.
     * Note 1: Every item can be picked at max one time.
     * Note 2: We cannot take a part of item.
     * **/
    static int[][] DP;
    private static int solve(int[] weights, int[] values, int K) {
        int N = weights.length;
        DP = new int[N][K + 1];
        for (int p = 0; p < N; p++) {
            Arrays.fill(DP[p], -1);
        }
        return knapsack(N - 1, K, weights, values);
    }
    private static int knapsack(int i, int j, int[] weights, int[] values) {
        if (i < 0 || j <= 0) {
            return 0;
        }
        if (DP[i][j] == -1) {
            int A = knapsack(i - 1, j, weights, values);
            if (j >= weights[i]) {
                A = Math.max(A, knapsack(i - 1, j - weights[i], weights, values) + values[i]);
            }
            DP[i][j] = A;
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int K = 15;
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int result = solve(weights, values, K);
        PrintUtils.print(result);
    }
}
