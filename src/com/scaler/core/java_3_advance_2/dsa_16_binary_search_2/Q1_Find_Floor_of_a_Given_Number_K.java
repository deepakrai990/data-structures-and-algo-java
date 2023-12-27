package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Find_Floor_of_a_Given_Number_K {
    /**
     * Given a sorted array.
     * Find a floor of a given number K.
     * Return the index.
     * Ideas:
     * Idea 1: Traverse the array & keep on searching until elements are smaller or equal to K.
     * Idea 2: Use Binary Search
     * **/
    private static int floor(int[] A, int K) {
        int left = 0, right = A.length, result = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] == K) return mid;
            else if (A[mid] < K) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {-5, 2, 3, 6, 9, 10, 11, 14, 18};
        int K = 5;
        int result = floor(A, K);
        PrintUtils.print(result);
    }
}
