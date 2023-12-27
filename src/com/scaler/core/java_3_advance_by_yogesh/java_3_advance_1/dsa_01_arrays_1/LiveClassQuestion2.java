package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1;

import java.util.Arrays;

/**
 * @created 01/01/23 9:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given A[N] where all elements are zero(0).
     * Given a query Q which has index and val.
     * Add the value from index onwards.
     **/
    private static int[] solve(int[] arr, int[][] queryArr) {
        int n = arr.length;
        int query = queryArr.length;
        int i = 0;
        while (i < query) {
            // given start, end, value
            int start = queryArr[i][0];
            int end = queryArr[i][1];
            int value = queryArr[i][2];
            arr[start] += value;
            if (end + 1 < n) {
                arr[end + 1] -= value;
            }
            i++;
        }
        int[] pfSum = new int[n];
        pfSum[0] = arr[0];
        for (int j = 1; j < n; j++) {
            pfSum[j] = pfSum[j - 1] + arr[j];
        }
        return pfSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[][] queryArr = {{3, 6, 1}, {2, 7, 3}, {5, 8, -3}, {1, 9, 2}};
        int[] results = solve(arr, queryArr);
        System.out.println(Arrays.toString(results));
    }
}
