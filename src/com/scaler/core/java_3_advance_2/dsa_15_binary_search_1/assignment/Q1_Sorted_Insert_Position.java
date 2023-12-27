package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sorted_Insert_Position {
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
        PrintUtils.print(result);
    }
}
