package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q5_Find_the_number_of_distinct_elements {
    /**
     * Problem: Find the number of distinct elements
     * Given array A[N]. Find the number of distinct elements
     * **/
    // Function to find the number of distinct elements in an array
    private static int countDistinctElements(int[] array) {
        // Use a HashSet to store unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();
        // Iterate through the array and add elements to the HashSet
        for (int element : array) {
            uniqueElements.add(element);
        }
        // The size of the HashSet represents the number of distinct elements
        return uniqueElements.size();
    }
    public static void main(String[] args) {
        int[] A = {6, 3, 7, 3, 8, 6, 9}; // Example array
        // Function call to find the number of distinct elements
        int result = countDistinctElements(A);
        // Print the result
        System.out.println("Number of Distinct Elements: " + result);
    }
}
