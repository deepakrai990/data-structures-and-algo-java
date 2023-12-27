package com.scaler.core.java_3_advance_2.dsa_14_sorting_3.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:28 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Maximum_Unsorted_Subarray {
    private static int[] subUnSort(int[] A) {
        int[] ans = {-1};
        int n = A.length;
        int r = -1, l = 0;
        for (int i = n - 1; i > 0; i--) {
            if (A[i] < A[i - 1]) {
                r = i;
                break;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (A[i + 1] < A[i]) {
                l = i;
                break;
            }
        }
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int i = l; i <= r && i < n; i++) {
            minElement = Math.min(minElement, A[i]);
            maxElement = Math.max(maxElement, A[i]);
        }
        int i = 0, j = n - 1;
        if (r != -1) {
            while (A[i] <= minElement && i <= l) {
                i++;
            }
            while (A[j] >= maxElement && j >= r) {
                j--;
            }
        } else return ans;

        int[] ans2 = {i, j};
        return ans2;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        int[] A1 = {1, 2, 3, 4, 5};
        int[] results = subUnSort(A);
        PrintUtils.print1DArray(results);
        PrintUtils.printNewLine();
        int[] results1 = subUnSort(A1);
        PrintUtils.print1DArray(results1);
    }
}
