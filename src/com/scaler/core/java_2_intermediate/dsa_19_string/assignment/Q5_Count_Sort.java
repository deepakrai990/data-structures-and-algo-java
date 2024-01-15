package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Count_Sort {
    private static int[] solve(int[] A) {
        int size = A.length;
        int[] output = new int[size + 1];
        // Find the largest element of the array
        int max = A[0];
        for (int i = 1; i < size; i++) {
            if (A[i] > max)
                max = A[i];
        }

        int[] count = new int[max + 1];

        // Initialize a count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[A[i]]++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in a count array, and
        // place the elements in the output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        // Copy the sorted elements into an original array
        for (int i = 0; i < size; i++) {
            A[i] = output[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
