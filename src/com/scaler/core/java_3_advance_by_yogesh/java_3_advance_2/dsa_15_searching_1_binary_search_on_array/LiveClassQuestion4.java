package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array;

/**
 * @created 08/02/23 1:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
    /**
     * Given unsorted array A[] with distinct elements, return any local minima.
     * An element is said to be local minima, if it is less than its adjacent elements.
     * Input
     * int[8] A = {9, 8, 7, 3, 6, 4, 1, 5, 2};
     * Index    = {0, 1, 2, 3, 4, 5, 6, 7, 8}
     * Example
     * local minima ---> A[i - 1] > A[i] < A[i+ 1]
     *              |
     *              |   A[0] < A[1]
     * Edge cases   |
     *              |   A[n - 1] < A[n - 2]
     *              |
     * **/
    private static int findLocalMinima(int[] A) {
        int n = A.length, low = 1, high = n - 2;
        if (A[0] < A[1]) return A[0];
        if (A[n - 1] < A[n - 2]) return A[n - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) return A[mid];
            else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {9, 8, 7, 3, 6, 4, 1, 5, 2};
        int result = findLocalMinima(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
