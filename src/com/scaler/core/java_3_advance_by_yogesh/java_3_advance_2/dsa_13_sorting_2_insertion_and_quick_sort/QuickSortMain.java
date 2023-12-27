package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_13_sorting_2_insertion_and_quick_sort;

/**
 * @created 31/01/23 7:57 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QuickSortMain {
    /**
     * QUICKSORT(A, start, end)
     *     if start < end
     *         pivot_index = PARTITION(A, start, end)
     *         QUICKSORT(A, start, pivot_index - 1)
     *         QUICKSORT(A, pivot_index + 1, end)
     *
     * PARTITION(A, start, end)
     *     pivot = A[end]
     *     pivot_index = start
     *     for i = start to end - 1
     *         if A[i] <= pivot
     *             swap A[i] with A[pivot_index]
     *             pivot_index = pivot_index + 1
     *     swap A[pivot_index] with A[end]
     *     return pivot_index
     * **/
    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
