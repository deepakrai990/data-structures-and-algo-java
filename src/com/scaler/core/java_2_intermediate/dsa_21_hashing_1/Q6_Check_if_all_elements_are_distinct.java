package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q6_Check_if_all_elements_are_distinct {
    /**
     * Problem: Check if all elements are distinct
     * Given array A[N]. Check if all elements are distinct
     * **/
    private static boolean areAllElementsDistinct(int[] A) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int element : A) {
            uniqueElements.add(element);
        }
        if (uniqueElements.size() < A.length) {
            return false;
        } else {
            return true;
        }
    }
    private static boolean areAllElementsDistinct1(int[] array) {
        // Use a HashSet to store unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();
        // Iterate through the array
        for (int element : array) {
            // If the element is already in the HashSet, it's a duplicate
            if (!uniqueElements.add(element)) {
                return false; // Not all elements are distinct
            }
        }
        // All elements are distinct
        return true;
    }
    public static void main(String[] args) {
        int[] A = {3, 1, 6, 1, 4, 9, 8}; // {6, 8, 3, 2, 7};
        // Function call to check if all elements are distinct
        boolean result = areAllElementsDistinct(A);
        // Print the result
        System.out.println("All Elements Are Distinct: " + result);
    }
}
