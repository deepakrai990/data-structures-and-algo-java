package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_BubbleSort {
    private static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean isSwaped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
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
        int[] a = {4, 6, 4, 3, 9, -1, 5, 2};
        bubbleSort(a);
        PrintUtils.print1DArray(a);
    }
}
