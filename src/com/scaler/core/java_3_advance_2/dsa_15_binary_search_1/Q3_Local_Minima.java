package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 6:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Local_Minima {
    /**
     * Given an array of N distinct elements.
     * Find index of any one local minimum in the array.
     * **/
    private static int findLocalMinimum(int[] A) {
        int N = A.length;
        if (N == 1) return 0;
        if (A[0] < A[1]) return 0;
        if (A[N - 1] < A[N - 2]) return N - 1;
        int left = 1;
        int right = N - 2;
        while (left <= right) {
            int mid = left + (right + left) / 2;
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {8, 6, 1, 0, 9, 15, 16};
        int result = findLocalMinimum(A);
        PrintUtils.print(result);
    }
}
