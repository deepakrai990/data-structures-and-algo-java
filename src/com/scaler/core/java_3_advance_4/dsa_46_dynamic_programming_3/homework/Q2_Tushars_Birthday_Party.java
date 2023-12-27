package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.homework;

/**
 * @created 02/04/23 10:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Tushars_Birthday_Party {
    //top down
    // DO NOT MODIFY THE ARGUMENTS WITH “final” PREFIX. IT IS READ ONLY
    Integer[][] dp;

    private int solve(final int[] A, final int[] B, final int[] C) {
        int n = A.length;
        int maxCapacity = 0;
        dp = new Integer[B.length + 1][1001];

        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += findMinCost(0, B.length, A[i], B, C);
        }
        return minCost;
    }

    private int findMinCost(int index, int n, int capacity, int[] fillingCapacity, int[] cost) {
        if (capacity == 0 && index == n)
            return 0;
        if (index == n)
            return 999999;

        if (dp[index][capacity] != null)
            return dp[index][capacity];

        if (fillingCapacity[index] <= capacity) {
            dp[index][capacity] = Math.min(
                    findMinCost(index, n, capacity - fillingCapacity[index], fillingCapacity, cost) + cost[index],
                    findMinCost(index + 1, n, capacity, fillingCapacity, cost)
            );
        } else
            dp[index][capacity] = findMinCost(index + 1, n, capacity, fillingCapacity, cost);

        return dp[index][capacity];
    }

    //bottom up
    // DO NOT MODIFY THE ARGUMENTS WITH “final” PREFIX. IT IS READ ONLY
    private int solve_1(final int[] A, final int[] B, final int[] C) {
        int maxCapacity = 0;
        for (int capacity : A)
            maxCapacity = Math.max(maxCapacity, capacity);

        int dp[] = new int[maxCapacity + 1];
        for (int i = 1; i <= maxCapacity; i++) {
            int minCost = 999999;
            for (int j = 0; j < B.length; j++) {
                if (B[j] <= i) {
                    int selected = C[j] + dp[i - B[j]];
                    minCost = Math.min(minCost, selected);
                }
            }
            dp[i] = minCost;
        }

        int ans = 0;
        for (int capacity : A) {
            ans += dp[capacity];
        }
        return ans;
    }

}
