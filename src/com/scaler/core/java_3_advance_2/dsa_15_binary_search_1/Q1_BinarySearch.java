package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 7:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_BinarySearch {
    private static int binarySearch(int[] A, int K) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] == K) return mid;
            else if (A[mid] < K) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {3, 6, 9, 12, 14, 19, 20, 23, 25, 27};
        int K = 12;
        int result = binarySearch(A, K);
        PrintUtils.print(result);
    }
}
