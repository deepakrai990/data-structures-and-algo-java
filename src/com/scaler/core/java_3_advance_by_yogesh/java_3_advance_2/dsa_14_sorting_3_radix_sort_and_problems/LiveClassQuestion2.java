package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_14_sorting_3_radix_sort_and_problems;

import java.util.Arrays;

/**
 * @created 03/02/23 5:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Count Sort.
     * Sort the given array using count sort.
     * Range of data
     * -10 <= A[i] <= 10
     * Input
     * A = {3, -8, -10, 3, 0, 10, 2, -6, -8}
     * [a, b] = b - a + 1
     * **/
    private static void countSort1(int[] A, int min, int max) {
        int n = A.length;
        int dataRangeSize = max - min + 1; // [a b] = b - a + 1
        int[] freq = new int[dataRangeSize];
        for (int i = 0; i < n; i++) {
            freq[A[i] - min]++;
        }
        int k = 0;
        for (int i = min; i <= max; i++) {
            for (int j = 1; j <= freq[i - min]; j++) {
                A[k++] = i;
            }
        }
    }
    private static void countSortCustomByMe(int[] A) {
        int n = A.length;
        int min = A[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, A[i]);
        }
        int max = A[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
        }
        int dataRangeSize = max - min + 1; // [a b] = b - a + 1
        int[] freq = new int[dataRangeSize];
        for (int i = 0; i < n; i++) {
            freq[A[i] - min]++;
        }
        int k = 0;
        for (int i = min; i <= max; i++) {
            for (int j = 1; j <= freq[i - min]; j++) {
                A[k++] = i;
            }
        }
    }
    /*
    private static void countSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    */
    /*
    private static void countSort2(int array[], int size) {
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }
    */
    public static void main(String[] args) {
        int[] A = {3, -8, -10, 3, 0, 10, 2, -6, -8};
        int min = -10, max = 10;
        countSort1(A, min, max);
        System.out.printf("%s%5s", "Results : ", Arrays.toString(A));
        System.out.println();
        int[] A1 = {3, -8, -10, 3, 0, 10, 2, -6, -8};
        countSortCustomByMe(A1);
        System.out.printf("%s%5s", "Results : ", Arrays.toString(A1));

    }
}
