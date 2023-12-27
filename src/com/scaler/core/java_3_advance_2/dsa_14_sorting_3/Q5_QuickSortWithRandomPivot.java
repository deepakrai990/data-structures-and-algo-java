package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

import java.util.Random;

/**
 * @created 26/09/23 10:44 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_QuickSortWithRandomPivot {
    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Choose a random pivot index and partition the array
            int pivotIndex = randomPartition(arr, start, end);
            // Recursively sort elements before and after the pivot
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }
    private static int randomPartition(int[] arr, int start, int end) {
        // Generate a random pivot index within the range [start, end]
        Random random = new Random();
        int randomIndex = random.nextInt(end - start + 1) + start;

        // Swap the randomly selected pivot element with the last element
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[end];
        arr[end] = temp;

        return partition(arr, start, end);
    }
    public static int partition(int[] arr, int start, int end) {
        // Choose the rightmost element as the pivot
        int pivot = arr[end];
        int i = start - 1;

        // Iterate through the array and rearrange elements
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                // Swap arr[i] and arr[j]
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and the pivot element (arr[end])
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        // Return the pivot index
        return i + 1;
    }
    public static void main(String[] args) {
        int[] A = {18, 8, 6, 3, 11, 14, 23, 20, 31, 27};
        int start = 0, end = A.length - 1;
        PrintUtils.print1DArray(A);
        quickSort(A, start, end);
        PrintUtils.printNewLine();
        PrintUtils.print1DArray(A);
    }
}
