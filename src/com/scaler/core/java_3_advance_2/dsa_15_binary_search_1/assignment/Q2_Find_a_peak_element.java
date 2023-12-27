package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Find_a_peak_element {
    private static int solve(int[] A) {
        int n = A.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if ((mid == 0 || (A[mid] >= A[mid - 1])) &&
                    (mid == A.length - 1 || A[mid] >= A[mid + 1])) {
                return A[mid];
            }
            if (mid == 0 || A[mid] >= A[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
