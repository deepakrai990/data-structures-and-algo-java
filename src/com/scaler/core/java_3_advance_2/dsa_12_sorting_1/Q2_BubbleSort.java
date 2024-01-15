package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_BubbleSort {
    private static void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
    }
    private static void bubbleSort1(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            boolean isSwaped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    isSwaped = true;
                }
            }
            if (!isSwaped) break;
        }
    }
    private static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {4, 6, 4, 3, 9, -1, 5, 2};
        System.out.println("Unsorted Array: " + Arrays.toString(A));
        bubbleSort(A);
        System.out.println("Sorted Array: " + Arrays.toString(A));

        System.out.println("----------------------------------------------------------");

        int[] A1 = {4, 6, 4, 3, 9, -1, 5, 2};
        System.out.println("Unsorted Array: " + Arrays.toString(A1));
        bubbleSort1(A1);
        System.out.println("Sorted Array: " + Arrays.toString(A1));
    }
}
