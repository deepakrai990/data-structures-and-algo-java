package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

import java.util.Arrays;

/**
 * @created 28/01/23 4:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Selection Sort
     * T.C = O(N^2)
     * S.C = O(1)
     * Not stable sorting
     * **/
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2, 8, 4, -1, 6, 7, 5, 10, -1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
