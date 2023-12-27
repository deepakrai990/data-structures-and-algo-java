package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array;

/**
 * @created 06/02/23 11:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given on increasing and decreasing array with distinct elements, find max element?
     * Input
     * int[] A = {1, 3, 5, 10, 15, 12, 6};
     * T.C O(log n)
     * S>C= O(1)
     **/
    private static int findMaxElement(int[] A) {
        int n = A.length, low = 0, high = n - 1;
        if (low == high) return A[low];
        // Edge case for if array length is 2
        if (n == 2)
            if (A[0] < A[1]) return A[1];
            else return A[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0 && A[mid] > A[mid + 1]) return A[mid];
            if (mid == n - 1 && A[mid] > A[mid - 1]) return A[mid];

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return A[mid];
            else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 10, 15, 12, 6};
        int result = findMaxElement(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
