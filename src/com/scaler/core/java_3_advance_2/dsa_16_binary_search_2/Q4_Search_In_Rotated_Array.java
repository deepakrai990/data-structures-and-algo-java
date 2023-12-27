package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 8:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Search_In_Rotated_Array {
    private static int searchInRotatedArray(int[] A, int K) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] == K) {
                return mid;
            }
            if (A[left] <= A[mid]) {
                if (A[left] <= K && A[mid] > K) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < K && A[mid] >= K) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {10, 20, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int K = 20;
        int result = searchInRotatedArray(A, K);
        PrintUtils.print(result);
    }
}
