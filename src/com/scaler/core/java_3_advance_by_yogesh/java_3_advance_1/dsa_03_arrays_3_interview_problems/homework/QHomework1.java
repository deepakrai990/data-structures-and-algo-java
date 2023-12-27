package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.homework;

import java.util.Arrays;

/**
 * @created 10/02/23 12:22 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int[] nextPermutation(int[] A) {
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = A.length - 1;
            while (j >= 0 && A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1);
        return A;
    }

    private static void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void reverse(int[] A, int start) {
        int end = A.length - 1;
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] results = nextPermutation(A);
        System.out.printf("%s%5s", "Results: ", Arrays.toString(results));
    }
}
