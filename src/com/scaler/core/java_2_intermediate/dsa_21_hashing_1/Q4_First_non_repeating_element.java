package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q4_First_non_repeating_element {
    /**
     * Problem: Find the first non-repeating element
     * Given array A[N]. Find the first non-repeating element
     * **/
    // Function to find the first non-repeating element in an array
    private static int findFirstNonRepeatingElement(int[] array) {
        // LinkedHashMap is used to maintain the order of insertion
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Iterate through the array to count frequencies
        for (int element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        // Iterate through the HashMap to find the first non-repeating element
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        // If no non-repeating element is found, return a default value (e.g., -1)
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 2, 1, 5, 3, 6}; // Example array
        // Function call to find the first non-repeating element
        int result = findFirstNonRepeatingElement(A);
        // Print the result
        System.out.println("First Non-Repeating Element: " + result);
    }
}
