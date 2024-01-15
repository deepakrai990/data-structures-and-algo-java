package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 23/09/23 10:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_SelectionSort {
    private static void selectionSort(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            // ith iteration
            int minVal = A[i], minIndex = i;
            for (int j = i; j < N; j++) {
                if (A[j] < minVal) {
                    minVal = A[j];
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        }
    }
    private static void selectionSort1(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min_idx = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            swap(a, i, min_idx);
        }
    }
    private static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {10, 2, 3, 1, 2, 9};
        System.out.println("Unsorted Array: " + Arrays.toString(A));
        selectionSort(A);
        System.out.println("Sorted Array: " + Arrays.toString(A));

        System.out.println("----------------------------------------------------------");

        int[] A1 = {10, 2, 3, 1, 2, 9};
        System.out.println("Unsorted Array: " + Arrays.toString(A1));
        selectionSort1(A1);
        System.out.println("Sorted Array: " + Arrays.toString(A1));
    }
}
