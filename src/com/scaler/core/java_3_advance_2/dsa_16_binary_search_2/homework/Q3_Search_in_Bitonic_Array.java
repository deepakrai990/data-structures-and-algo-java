package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2.homework;

/**
 * @created 02/04/23 7:22 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Search_in_Bitonic_Array {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int max = 0;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                max = mid;
                break;
            } else if (A[mid] < A[mid + 1]) {
                s = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                e = mid - 1;
            }
        }
        s = 0;
        e = max;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                s = mid + 1;
            } else if (A[mid] > B) {
                e = mid - 1;
            }
        }
        s = max;
        e = n - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                e = mid - 1;
            } else if (A[mid] > B) {
                s = mid + 1;
            }
        }
        return -1;
    }
}
