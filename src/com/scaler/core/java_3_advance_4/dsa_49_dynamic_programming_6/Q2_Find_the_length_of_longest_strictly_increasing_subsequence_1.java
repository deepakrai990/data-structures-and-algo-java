package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 22/12/23
 * @project scaler_course_code
 */
public class Q2_Find_the_length_of_longest_strictly_increasing_subsequence_1 {
    /**
     * Problem: Given array A[N, find the length of longest strictly increasing subsequence.
     * **/
    private static int lis(int[] A, int N) {
        int[] DP = new int[N];
        int ans = 0;
        Arrays.fill(DP, - 1);
        for (int i = 0; i < N; i++) {
            // Calculate DP[i]
            int c = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    c = Math.max(c, DP[j]);
                }
            }
            DP[i] = c + 1;
            ans = Math.max(DP[i], ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, -1, 6, 3, 7, 9}; // {10, 3, 12, 7, 2, 9, 11, 20, 11, 13, 6, 8};
        int result = lis(A, A.length);
        PrintUtils.print(result);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}
