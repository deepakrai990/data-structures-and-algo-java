package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array;

/**
 * @created 08/02/23 3:20 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion5 {
    /**
     * Every element in an array occurs twice except for one. Find the unique element.
     * Note:- Duplicates are adjacent to each other.
     * Input
     * int[] A = {3, 3, 1, 1, 8, 8, 10, 10, 9, 6, 6, 2, 2, 4, 4};
     * **/
    private static int findUniqueElement(int[] A) {
        int n = A.length, low = 0, high = n - 1;
        if (A[0] != A[1]) return A[0];
        if (A[n - 1] != A[n - 2]) return A[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) return A[mid];
            int first = mid;
            if (A[mid - 1] == A[mid]) first = mid - 1;
            if (first % 2 == 0) // Move right hand side
                low = first + 2;
            else // Move right hand side
                high = first - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {3, 3, 1, 1, 8, 8, 10, 10, 9, 6, 6, 2, 2, 4, 4};
        int result = findUniqueElement(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
