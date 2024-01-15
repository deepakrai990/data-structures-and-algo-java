package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

import java.util.Arrays;

/**
 * @created 15/09/22 10:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Equlibrium_Index {
    /**
     * Equilibrium index
     *
     * Given an array of N elements. Count the number of equilibrium index.
     * if i == 0 then leftSum = 0
     * if i == n - 1 then rightSum = 0
     *
     * Equilibrium index: index of i is equilibrium index if sum of all elements to left of i index is equal to sum of
     * all elements to right of i index
     * sum[0 to i - 1] = sum[i + 1 to n - 1]
     * sum[0   i - 1] = sum[i + 1   n - 1]
     * **/
    private static int solve(int[] a, int size) {
        int cnt = 0;
        int[] prefixSum = new int[size];
        prefixSum[0] = a[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        for (int i = 0; i < size; i++) {
            // check if i = equilibrium index
            int leftSum = 0;
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = prefixSum[i - 1] ;
            }
            int rightSum = prefixSum[size - 1] - prefixSum[i];
            if (leftSum == rightSum) {
                cnt++;
            }
        }
        /**
         * T.C = O(N)
         * S.C = O(N)
         * **/
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};
        int totalEquilibriumIndexes = solve(a, a.length);
        System.out.println("totalEquilibriumIndexes : " + totalEquilibriumIndexes);
        Arrays.toString(a);
    }
}
