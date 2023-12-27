package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 8:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Search_in_a_Sorted_but_rotated_Array {
    /**
     * Search in a sorted but rotated array.
     * **/
    private static int findPivot(int[] A) {
        int left = 0, right = A.length - 1, pivot = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] < A[0]) {
                pivot = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pivot;
    }
    public static void main(String[] args) {
        int[] A = {4, 5, 8, 10, 1, 2, 3};
        int result = findPivot(A);
        PrintUtils.print(result);
    }
}
