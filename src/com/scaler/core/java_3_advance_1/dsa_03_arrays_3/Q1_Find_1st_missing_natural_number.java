package com.scaler.core.java_3_advance_1.dsa_03_arrays_3;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Find_1st_missing_natural_number {
    /**
     * Given an array A[N]. Find the first missing natural number.
     * **/
    private static int missingNumber1(int[] A) {
        int N = A.length;
        int missingNumber = N + 1;
        for (int i = 1; i <= N; i++) {
            // Search for i in the array
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (A[j] == i) {
                    found = true;
                    break;
                }
            }
            // If the natural number is not found, it is the missing number
            if (!found) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
    private static int missingNumber2(int[] A) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();
        // Add elements of the array to the HashSet
        for (int num : A) {
            set.add(num);
        }
        // Find the first missing natural number
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // This should not be reached
    }
    // Function to find the first missing natural number using sorting and iterating
    private static int missingNumber3(int[] A) { // this logic can apply on positive numbers only
        Arrays.sort(A);
        int n = A.length;
        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            // Check if the current element is equal to the expected natural number
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        // If all elements match the expected natural numbers, return the next natural number
        return n + 1;
    }
    private static int missingNumber4(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            while (A[i] > 0 && A[i] <= N && A[i] != (i + 1)) {
                int val = A[i];
                if (A[i] == A[val - 1]) {
                    break;
                }
                swap(A, i, val - 1);
            }
        }
        // Iterate & get missing number
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return N + 1;
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {3, -2, 1, 2, 7};

        int result = missingNumber1(A);
        System.out.println("Brute-force Approach - Missing Number: " + result);

        int[] A2 = {3, -2, 1, 2, 7};
        result = missingNumber2(A2);
        System.out.println("Brute-force Approach - Missing Number: " + result);

        int[] A3 = {3, -2, 1, 2, 7};
        result = missingNumber3(A3);
        System.out.println("Brute-force Approach - Missing Number: " + result);

        int[] A4 = {4, 1, 3, 3, 2};
        result = missingNumber4(A4);
        System.out.println("Brute-force Approach - Missing Number: " + result);
    }
}
