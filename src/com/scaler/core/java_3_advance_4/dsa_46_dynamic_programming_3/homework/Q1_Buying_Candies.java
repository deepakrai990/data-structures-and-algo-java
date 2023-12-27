package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.homework;

/**
 * @created 02/04/23 10:15 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Buying_Candies {
    //top down
    Integer dp[][];

    private int solve(int[] A, int[] B, int[] C, int D) {
        dp = new Integer[A.length + 1][D + 1];
        return findMaxSweetnes(0, A.length, A, B, C, D);
    }

    private int findMaxSweetnes(int index, int n, int[] candies, int[] sweetnes, int[] cost, int nibbles) {
        if (index == n || nibbles <= 0)
            return 0;

        if (dp[index][nibbles] != null)
            return dp[index][nibbles];

        if (cost[index] <= nibbles) {
            dp[index][nibbles] = Math.max(
                    findMaxSweetnes(index, n, candies, sweetnes, cost, nibbles - cost[index]) + (candies[index] * sweetnes[index]), //selected
                    findMaxSweetnes(index + 1, n, candies, sweetnes, cost, nibbles)  // not selected
            );

        } else {
            dp[index][nibbles] = findMaxSweetnes(index + 1, n, candies, sweetnes, cost, nibbles);
        }
        return dp[index][nibbles];
    }


    //bottom up approach
    private int solve_1(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        int dp[] = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            int maxSweetness = 0;
            for (int j = 0; j < n; j++) {
                if (C[j] <= i) {
                    int selected = (A[j] * B[j]) + dp[i - C[j]];
                    maxSweetness = Math.max(maxSweetness, selected);
                }
            }
            dp[i] = maxSweetness;
        }
        return dp[D];
    }
}
