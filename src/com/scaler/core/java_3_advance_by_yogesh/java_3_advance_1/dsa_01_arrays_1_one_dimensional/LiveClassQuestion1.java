package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1_one_dimensional;

import java.util.Arrays;

/**
 * @created 08/01/23 1:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Initially all elements of an array[] are O you are given queries. Every query contains index and valve
     * Increment elements from ith index to last index by valve. Return final state of array[].
     **/
    /*
     * Solve by Brute Force Approach:- For every query, iterate and update your array by the given value.
     */
    private static int[] solveByBruteForce(int[] arr, int[][] queryArr) {
        int n = arr.length;
        int query = queryArr.length;
        int i = 0;
        while (i < query) {
            int index = queryArr[i][0];
            int value = queryArr[i][1];
            for (int j = index; j < n; j++) {
                arr[j] = arr[j] + value;
            }
            i++;
        }
        return arr;
    }

    private static int[] solveByUsingPrefixSum(int[] arr, int[][] queryArr) {
        int n = arr.length;
        int query = queryArr.length;
        int i = 0;
        while (i < query) {
            int index = queryArr[i][0];
            int value = queryArr[i][1];
            arr[index] = value;
            i++;
        }
        for (int j = 1; j < n; j++) {
            arr[j] = arr[j - 1] + arr[j];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[7];
        int[][] queryArr = {{3, 4}, {1, 3}, {4, -2}};
        int[] results = solveByBruteForce(arr, queryArr);
        System.out.println("--------------------------By Using Brute Force--------------------------");
        System.out.println(Arrays.toString(results));
        System.out.println("--------------------------By Using Prefix Sum--------------------------");
        int[] arr1 = new int[7];
        int[][] queryArr1 = {{3, 4}, {1, 3}, {4, -2}};
        int[] results1 = solveByUsingPrefixSum(arr1, queryArr1);
        System.out.println(Arrays.toString(results1));
    }
}
