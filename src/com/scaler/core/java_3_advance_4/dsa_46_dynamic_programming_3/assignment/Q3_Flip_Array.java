package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.assignment;

/**
 * @created 02/04/23 10:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Flip_Array {
    // DO NOT MODIFY THE ARGUMENTS WITH “final” PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {
        int sum = 0;
        for (int n : A) {
            sum += n;
        }
        //how to get close to min non negative and 0 if I subtract half of sum from sum = sum - (sum/2)
        //Now from elements of array I need to find out the half sum is possible or NOT
        //if possible than min no. of elements required to make half sum
        //for this I will create a one dimensional dp from 0 to half where each i represent a pair to represent above points
        int half = sum / 2;
        int[][] dp = new int[half + 1][];
        for (int i = 0; i <= half; i++) {
            int minElements = findMinFlip(i, A); // nothing but 0/1 knapsack
            if (minElements <= A.length) {
                dp[i] = new int[]{1, minElements};
            } else
                dp[i] = new int[]{0, -1};
        }
        for (int i = half; i >= 0; i--) {
            if (dp[i][0] == 1) {
                return dp[i][1];
            }
        }
        return 0;
    }

    public int findMinFlip(int remainingCapacity, int[] A) {
        int minDP[][] = new int[A.length + 1][remainingCapacity + 1];

        for (int j = 1; j <= remainingCapacity; j++) {
            minDP[0][j] = 9999999;
        }
        int n = A.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= remainingCapacity; j++) {
                if (A[i - 1] <= j) {
                    minDP[i][j] = Math.min(minDP[i - 1][j], 1 + minDP[i - 1][j - A[i - 1]]);
                } else {
                    minDP[i][j] = minDP[i - 1][j];
                }
            }
        }
        return minDP[n][remainingCapacity];
    }
}
