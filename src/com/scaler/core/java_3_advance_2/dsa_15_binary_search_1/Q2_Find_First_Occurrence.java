package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 6:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Find_First_Occurrence {
    /**
     * Given a sorted array A[N], find the first occurrence of
     * given element K.
     * **/
    private static int findFirstOccurrence(int[] A, int K) {
        int left = 0;
        int right = A.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == K) {
                result = mid; // Update the result to the current middle index.
                right = mid - 1; // Continue searching in the left half for the first occurrence.
            } else if (A[mid] < K) {
                left = mid + 1; // The Target is in the right half;
            } else {
                right = mid - 1; // The target is in the left half;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 3, 4, 4, 5};
        int K = 2;
        int result = findFirstOccurrence(A, K);
        PrintUtils.print(result);
    }
}
