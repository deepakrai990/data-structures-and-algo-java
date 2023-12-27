package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

/**
 * @created 28/01/23 4:22 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given arr[N]. We can only swap adjacent elements, sort the array in increasing order
     * T.C = O(N^2)
     * S.C = O(1)
     * Inplace Sorting Algorithm
     * **/
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public static void main(String[] args) {

    }
}
