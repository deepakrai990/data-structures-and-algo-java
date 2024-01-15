package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 02/01/24
 * @project scaler_course_code
 */
public class Q5_Rotate_the_array_K_times_in_clockwise {
    private static void rotateByK(int[] A, int N, int K) {
        K = K % N;
        // Step 1: Reverse the whole array
        reverseArrByIdx(A, 0, N - 1);
        // Step 2: Reverse the first K elements
        reverseArrByIdx(A, 0, K - 1);
        // Step 3: Reverse the remaining N - K elements
        reverseArrByIdx(A, K, N - 1);
    }
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
        int[] A = {-1, 2, 3, 6, 5, 4, 8};
        int N = A.length;
        int K = 3;
        PrintUtils.print("Before Reverse : "+ Arrays.toString(A));

        rotateByK(A, N, K);
        PrintUtils.print("After  Reverse : "+ Arrays.toString(A));
    }
}
