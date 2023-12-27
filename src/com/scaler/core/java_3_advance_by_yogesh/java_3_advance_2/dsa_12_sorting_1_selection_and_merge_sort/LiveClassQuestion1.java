package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

/**
 * @created 28/01/23 4:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given arr[N] elements, find k^th smallest element.
     * { element can repeat }
     * arr[8] = {2, 8, 4, -1, 6, 7, 5, 10, -1}
     *  T.C = O(K * N)
     *  S.C = O(1)
     * **/
    private static int findKthElement(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < k; i++) {
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
        return arr[k - 1];
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2, 8, 4, -1, 6, 7, 5, 10, -1};
        int k = 5;
        int result = findKthElement(arr, k);
        System.out.println("Result : " + result);
    }
}
