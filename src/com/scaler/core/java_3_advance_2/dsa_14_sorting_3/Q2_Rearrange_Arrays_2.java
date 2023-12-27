package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 8:56 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Rearrange_Arrays_2 {
    private static void rearrangeArr(int[] A) {
        int N = A.length, P1 = 1, P2 = N - 1;
        while (P1 <= P2) {
            if (A[0] >= A[P1]) P1++;
            else if (A[0] < A[P2]) P2--;
            else {
                swap(A, P1, P2);
                P1++; P2--;
            }
        }
        swap(A, 0, P2);
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
        PrintUtils.print1DArray(A);
        PrintUtils.printNewLine();
        rearrangeArr(A);
        PrintUtils.print1DArray(A);
    }
}
