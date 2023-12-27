package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment;

/**
 * @created 09/02/23 11:45 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            int idx = A[i] - 1;
            if (A[i] != i + 1 && A[i] <= A.length && A[i] >= 1 && A[i] != A[idx]) {
                swap(A, i, idx);
            } else {
                i++;
            }
        }

        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return A.length + 1;
    }

    private static void swap(int[] A, int i, int idx) {
        int temp = A[i];
        A[i] = A[idx];
        A[idx] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};
        int result = firstMissingPositive(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
