package com.scaler.core.java_3_advance_2.dsa_15_binary_search_1.assignment;

/**
 * @created 02/04/23 7:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Rotated_Sorted_Array_Search {
    private static int search(final int[] A, int B) {
        int n = A.length - 1;
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B)
                return mid;
            else if (A[0] <= A[mid]) { //i.e. left part is sorted
                if (A[0] <= B && B < A[mid])
                    high = mid - 1; //B lies on left part
                else low = mid + 1;
            } else { //right part is sorted
                if (A[mid] < B && B <= A[n - 1])
                    low = mid + 1; //B lies on right part
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
