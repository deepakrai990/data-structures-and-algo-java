package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

import java.util.Arrays;

/**
 * @created 15/12/22 10:33 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {

    private static void reverse(int[] A, int N) {
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 4, 3, 9, 2, 6, 7};
        int N = A.length;
        reverse(A, N);
        System.out.println(Arrays.toString(A));
    }
}
