package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array.assignment;

/**
 * @created 09/02/23 7:56 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
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
        System.out.printf("%s%5s", "Result: ", result);
    }
}
