package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q3_Minimum_elements_required_1 {
    /**
     * Problem: Given A[N].
     * Find Minimum elements required to get sum equals K, all elements +ive
     * Note: Every element can be picked at most once.
     * **/
    static int[][] DP;
    private static int solve(int[] A, int N, int K) {
        DP = new int[N][K + 1];
        for (int[] row: DP) {
            Arrays.fill(row, N + 1);
        }
        return minElementsSubSum(N - 1, K, A);
    }
    private static int minElementsSubSum(int i, int j, int[] A) {
        if (i < 0) { // No elements
            if (j == 0) return 0; // We can get sum equals to 0 with no elements
            else return A.length + 1;
        }
        if (DP[i][j] == A.length + 1) { // Called for the first time
            int a = minElementsSubSum(i - 1, j, A); // Not picked
            int b = 0;
            if (j >= A[i]) {
                b = minElementsSubSum(i - 1, j - A[i], A) + 1; // Picked
            }
            DP[i][j] = Math.min(a, b);
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        int[] A = {7, 4, 9, 6, 10, 13, 14, 11};
        int N = A.length, K = 26;
        int result = solve(A, N, K);
        PrintUtils.print(result);
    }
}
