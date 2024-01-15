package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q3_Majority_Element_N_by_3 {
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
            // Check if the frequency is greater than N/3
            if (frequency > n / 3) {
                majorityElement = currentElement;
                break; // Break from the loop if a majority element is found
            }
        }
        return majorityElement;
    }
    // Optimise Approach 1
    private static int[] findMajorityElements(int[] array) {
        int n = array.length;
        int[] majorityElements = new int[2];
        // Initialize candidates and their counts
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        // Find potential majority candidates using Modified Boyer-Moore Voting Algorithm
        for (int num : array) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // Verify candidates' frequencies
        count1 = count2 = 0;
        for (int num : array) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        // Check if candidates appear more than N/3 times
        if (count1 > n / 3) {
            majorityElements[0] = candidate1;
        }
        if (count2 > n / 3) {
            majorityElements[1] =candidate2;
        }
        return majorityElements;
    }
    // Optimise Approach 2
    private static int findMajorityElement1(int[] array) {
        int n = array.length;
        // Initialize a candidate and its count
        int candidate = 0;
        int count = 0;
        // Find a potential majority candidate using Modified Boyer-Moore Voting Algorithm
        for (int num : array) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // Verify candidate's frequency
        count = 0;
        for (int num : array) {
            if (num == candidate) {
                count++;
            }
        }
        // Check if a candidate appears more than N/3 times
        if (count > n / 3) {
            return candidate;
        } else {
            return -1; // No majority element found
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int majorityElement = findMajorityElement(array);

        if (majorityElement != -1) {
            System.out.println("Majority Element: " + majorityElement);
        } else {
            System.out.println("No Majority Element");
        }

        System.out.println("-----------------------------------------");

        int[] array1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int[] result1 = findMajorityElements(array1);
        System.out.println("Input: " + Arrays.toString(array1));
        System.out.println("Majority Elements: " + Arrays.toString(result1));

        int[] array2 = {1, 2, 3, 4, 5};
        int[] result2 = findMajorityElements(array2);
        System.out.println("\nInput: " + Arrays.toString(array2));
        System.out.println("Majority Elements: " + Arrays.toString(result2));

        System.out.println("-----------------------------------------");

        int[] array3 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result3 = findMajorityElement(array3);
        System.out.println("Input: " + Arrays.toString(array3));
        System.out.println("Majority Element: " + result3);

        int[] array4 = {1, 2, 3, 4, 5};
        int result4 = findMajorityElement(array4);
        System.out.println("\nInput: " + Arrays.toString(array4));
        System.out.println("Majority Element: " + result4);
    }
}
