package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.homework;

/**
 * @created 02/04/23 7:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Sort_by_Color {
    private static int[] sortColors(int[] A) {
        int i = 0;
        int j = 0;
        int index = 0;
        int color = 0;
        while (i < A.length) {
            if (j < A.length) {
                if (A[j] != color) {
                    j++;
                } else {
                    swap(A, i, j);
                    index++;
                    i++;
                    j++;
                }
            }
            if (j == A.length) {
                color++;
                i = index;
                j = index;
            }
        }
        return A;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
