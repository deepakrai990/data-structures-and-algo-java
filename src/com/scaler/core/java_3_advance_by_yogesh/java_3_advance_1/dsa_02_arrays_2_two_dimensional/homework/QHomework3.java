package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.homework;

/**
 * @created 09/02/23 8:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int[] A) {
        int count = 0;
        int N = A.length;
        int s = 0;
        while (s < N) {
            if (A[s] != s) {
                count++;
                int temp = A[A[s]];
                A[A[s]] = A[s];
                A[s] = temp;
            } else s++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        int result = solve(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
