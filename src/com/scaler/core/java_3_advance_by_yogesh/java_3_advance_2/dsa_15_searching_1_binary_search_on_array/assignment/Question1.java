package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array.assignment;

/**
 * @created 09/02/23 7:48 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int searchInsert(int[] A, int B) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B)
                return mid;
            else if(A[mid] < B)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        int B = 5;
        int result = searchInsert(A, B);
        System.out.printf("%s%5s", "Result: ", result);
    }
}
