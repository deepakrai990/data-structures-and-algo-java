package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.homework;

/**
 * @created 31/01/23 8:47 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3 {
    /**
     * One approach to solve this problem is to use the merge sort algorithm to count the number of inversions as
     * we sort the array. The basic idea is to divide the array into smaller sub-arrays, sort each sub-array,
     * and then count the number of inversions as we merge the sub-arrays back together.
     * The number of inversions between two sub-arrays is equal to the number of elements remaining in the
     * first sub-array when a greater element from the second sub-array is selected during the merge process.
     *
     * Here's the Java pseudocode for counting the number of inversions using merge sort:
     *
     *
     * The mergeSortAndCountInversions function sorts the portion of the array specified by the start and end indices,
     * and returns the total number of inversions in that portion of the array. The mergeAndCountInversions function
     * merges two sorted sub-arrays and counts the number of inversions between them as it does so. Finally,
     * the result is taken modulo (10^9 + 7) to handle large numbers.
     * **/
    private  static int mergeSortAndCountInversions(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int count = mergeSortAndCountInversions(arr, start, mid);
            count += mergeSortAndCountInversions(arr, mid + 1, end);
            count += mergeAndCountInversions(arr, start, mid, end);
            return count;
        }
        return 0;
    }

    private static int mergeAndCountInversions(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, count = 0;
        for (int k = start; k <= end; k++) {
            if (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                    count += n1 - i;
                }
            } else if (i < n1) {
                arr[k] = left[i];
                i++;
            } else if (j < n2) {
                arr[k] = right[j];
                j++;
            }
        }
        return count;
    }
}
