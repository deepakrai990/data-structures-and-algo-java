package com.scaler.core.java_2_intermediate.dsa_22_hashing_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q3_Distinct_elements_in_subarray {
    /**
     * Problem: Count numbers of distinct elements in subarray
     * Given array A[N]. Calculate and print the numbers of distinct elements in subarray of size equals to K.
     * **/
    private static void printDistinctInSubarray(int[] A, int K) {
        int N = A.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < K; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        System.out.println(hm.size());
        int start = 1, end = K;
        while (end < N) {
            // Get subarray [s e], remove a[start - 1] and add a[end]
            hm.put(A[start - 1], hm.getOrDefault(A[start - 1], 0) - 1);
            if (hm.get(A[start - 1]) == 0) {
                hm.remove(A[start - 1]);
            }
            hm.put(A[end], hm.getOrDefault(A[end], 0) + 1);
            System.out.println(hm.size());
            start++;
            end++;
        }
    }
    // Function to calculate and print distinct elements in subarrays of size K
    private static void calculateAndPrintDistinctElements(int[] array, int windowSize) {
        // Use a HashMap to store elements and their frequencies in the current window
        HashMap<Integer, Integer> windowMap = new HashMap<>();
        // Initialize variables for the sliding window
        int left = 0;
        int right = 0;
        // Iterate through the array
        while (right < array.length) {
            // Expand the window
            windowMap.put(array[right], windowMap.getOrDefault(array[right], 0) + 1);
            // Check if the window size is equal to K
            if (right - left + 1 == windowSize) {
                // Print the number of distinct elements in the current window
                System.out.println("Distinct elements in subarray [" + left + ", " + right + "]: "
                        + windowMap.size());
                // Move the window by sliding it to the right
                windowMap.put(array[left], windowMap.get(array[left]) - 1);
                if (windowMap.get(array[left]) == 0) {
                    windowMap.remove(array[left]);
                }
                left++;
            }
            // Slide the window to the right
            right++;
        }
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 3, 8, 3, 9, 4, 9, 4, 10};
        int K = 4;

        printDistinctInSubarray(A, K);

        System.out.println("------------------------------");

        calculateAndPrintDistinctElements(A, K);
    }
}
