package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_13_sorting_2_insertion_and_quick_sort;

/**
 * @created 31/01/23 8:31 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class InsertionSortMain {
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
