package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1.assignment;

import java.util.Arrays;

/**
 * @created 04/01/23 4:30 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int[] solve(int A, int[][] B) {
        int[] coins = new int[A];
        for (int i = 0; i < A; i++) coins[i] = 0;
        // coins is an array which denotes the number of coins that each beggar has.
        // Initially each beggar has 0 coins.
        for (int i = 0; i < B.length; i++) {
            int leftIndex = B[i][0] - 1;
            int rightIndex = B[i][1] - 1;
            int donationByDevotee = B[i][2];
            coins[leftIndex] += donationByDevotee;
            if ((rightIndex + 1) < A) {
                coins[rightIndex + 1] -= donationByDevotee;
            }
        }
        int[] ans = prefixSum(coins);
        return ans;
    }

    private static int[] prefixSum(int[] A) {
        int[] pref = A;
        for (int i = 1; i < A.length; i++) {
            pref[i] += pref[i - 1];
        }
        return pref;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] results = solve(A, B);
        System.out.println(Arrays.toString(results));
    }
}
