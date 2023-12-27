package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1;

import java.util.Arrays;

/**
 * @created 01/01/23 8:22 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given A[] = 3, 2, -1, 5, 6, 8, 2, 3, 2, 6};
     * Given Query print sum in given range
     **/
    private static void printQuerySumInRange(int[] arr, int[][] queryArr) {
        // Prepare prefix sum
        int[] pfSum = new int[arr.length];
        pfSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pfSum[i] = pfSum[i - 1] + arr[i];
        }
        int query = queryArr.length;
        int i = 0;
        while (i < query) {
            int left = queryArr[i][0];
            int right = queryArr[i][1];
            int sum;
            if (left != 0) {
                sum = pfSum[right] - pfSum[left - 1];
            } else {
                sum = pfSum[right];
            }
            System.out.println("Sum for " + Arrays.toString(queryArr[i]) + ": " + sum);
            i++;
        }
        /**
         * Time Complexity  : O(N + Q)
         * Space Complexity : O(N)
         * **/
    }

    public static void main(String[] args) {
        int[] A = {3, 2, -1, 5, 6, 8, 2, 3, 2, 6};
        int[][] queryArr = {{1, 4}, {3, 6}, {1, 7}, {0, 5}};
        printQuerySumInRange(A, queryArr);
    }
}
