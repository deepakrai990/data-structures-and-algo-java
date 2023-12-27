package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 6:50 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Occurs_Twice_Except_One {
    /**
     * Given A[N]. Every element occurs twice except for one unique element.
     * Find that unique element.
     * Note: Duplicate elements are together
     * **/
    private static int findUnique(int[] A) {
        int N = A.length;
        if (N == 1) return A[0];
        if (A[0] != A[1]) return A[0];
        if (A[N - 1] != A[N - 2]) return A[N - 1];
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                return A[mid];
            }
            if (A[mid] == A[mid - 1]) { mid = mid - 1; }
            if (mid % 2 == 0) { left = mid + 2; }
            else { right = mid - 1; }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {3, 3, 1, 1, 8, 8, 10, 10, 19, 6, 6, 2, 2, 4, 4};
        int result = findUnique(A);
        PrintUtils.print(result);
    }
}
