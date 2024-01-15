package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 02/01/24
 * @project scaler_course_code
 */
public class Q4_Reverse_the_array_between_start_and_end {
    private static void reverseArrByIdx(int[] A, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(A, i, j);
            i++;
            j--;
        }
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {4, 6, 1, 3, 9, 2, 8, 7, 10};
        int start = 3;
        int end = 6;
        PrintUtils.print("Before Reverse : "+ Arrays.toString(A));

        reverseArrByIdx(A, start, end);
        PrintUtils.print("After  Reverse : "+ Arrays.toString(A));
    }
}
