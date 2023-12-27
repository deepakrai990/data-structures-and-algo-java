package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 30/11/23
 * @project scaler_course_code
 */
public class Q5_Chocolate_Distribution {
    // Function to calculate minimum chocolates required
    private static int minChocolates(int[] arr, int n) {
        // Sort the array to get minimum difference
        Arrays.sort(arr);
        // Initialize result
        int minChocolates = n;
        // Traverse through the array and calculate minimum chocolates
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                minChocolates += 1;
            }
        }
        return minChocolates;
    }
    public static void main(String[] args) {
        int[] studentMarks = {5, 3, 1, 4, 2, 6};
        int n = studentMarks.length;

        int result = minChocolates(studentMarks, n);

        System.out.println("Minimum number of chocolates required: " + result);
    }
}
