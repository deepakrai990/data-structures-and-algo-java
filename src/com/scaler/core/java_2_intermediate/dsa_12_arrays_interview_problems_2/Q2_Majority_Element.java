package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q2_Majority_Element {
    /**
     * Algorithms: Boyer-Moore Voting Algorithm
     * Problem: Majority Element
     * Given A[N] positive elements. Find the majority element with frequency
     * greater than (N / 2).
     * **/
    // Brute force Approach
    private static int findMajorityElement(int[] array) {
        int n = array.length;

        // Initialize the majority element
        int majorityElement = -1;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int currentElement = array[i];
            int frequency = 0;
            // Count the frequency of the current element
            for (int j = 0; j < n; j++) {
                if (array[j] == currentElement) {
                    frequency++;
                }
            }
            // Check if the frequency is greater than N/2
            if (frequency > n / 2) {
                majorityElement = currentElement;
                break; // Break from the loop if a majority element is found
            }
        }
        return majorityElement;
    }
    // Optimise Approach
    private static int findMajorityElement1(int[] A) {
        int N = A.length;
        int mejorityElement = 0;
        int count = 0;

        // Find the potential majority candidate using Boyer-Moore Voting Algorithm
        for (int i = 0; i < N; i++) {
            if (count == 0) {
                mejorityElement = A[i];
                count = 1;
            } else if (A[i] == mejorityElement) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is a majority element
        int candidateCount = 0;
        for (int num : A) {
            if (num == mejorityElement) {
                candidateCount++;
            }
        }

        if (candidateCount > N / 2) {
            return mejorityElement; // Found the majority element
        } else {
            return -1; // No majority element found
        }
    }
    public static void main(String[] args) {
        int[] A = {3, 4, 4, 8, 4, 9, 4, 3, 4};

        int result = findMajorityElement(A);
        PrintUtils.print(result);

        result = findMajorityElement1(A);
        PrintUtils.print(result);
    }
}
