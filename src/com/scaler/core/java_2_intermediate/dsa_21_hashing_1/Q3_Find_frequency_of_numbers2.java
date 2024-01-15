package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q3_Find_frequency_of_numbers2 {
    // Function to find frequencies of elements in an array
    private static HashMap<Integer, Integer> findFrequencies(int[] array) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        // Iterate through the array to count frequencies
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }

        return frequencies;
    }
    // Function to get the frequency of a specific element from the HashMap
    private static int getFrequency(HashMap<Integer, Integer> frequencies, int element) {
        return frequencies.getOrDefault(element, 0);
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 2, 5, 1, 2, 6}; // Example array
        int[] Q = {1, 2, 3, 4, 5, 6}; // Example queries

        // Function call to find frequencies for each query
        HashMap<Integer, Integer> frequencies = findFrequencies(A);

        // Process queries and print results
        for (int query : Q) {
            int frequency = getFrequency(frequencies, query);
            System.out.println("Frequency of " + query + ": " + frequency);
        }
    }
}
