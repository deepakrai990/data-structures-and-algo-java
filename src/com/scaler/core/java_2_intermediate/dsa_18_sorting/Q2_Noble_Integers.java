package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q2_Noble_Integers {
    /**
     * Problem: Noble Integers. {Data is distinct}
     * Given array A[N] with distinct elements. Calculate the number of noble integers.
     * Noble integer an element A[i] is said to be noble
     * if the number of elements is less than A[i] equal to A[i] itself.
     * **/
    // Bruteforce Approach 1
    private static int countNobleIntegers(int[] A) {
        int N = A.length, nobleCount = 0;
        for (int i = 0; i < N; i++) {
            // A[i], need elements < A[i]
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            if (A[i] == count) {
                nobleCount++;
            }
        }
        return nobleCount;
    }
    // Bruteforce Approach 2
    private static int countNobleIntegers1(int[] A) {
        int nobleCount = 0;
        // Iterate through each element in the array
        for (int i = 0; i < A.length; i++) {
            int currentElement = A[i];
            int greaterCount = 0;
            // Count the number of elements less than the current element
            for (int j = 0; j < A.length; j++) {
                if (A[j] < currentElement) {
                    greaterCount++;
                }
            }
            // Check if the count of lesser elements is equal to the current element
            if (greaterCount == currentElement) {
                nobleCount++;
            }
        }
        return nobleCount;
    }
    // Optimise Approach 1
    public static int countNobleIntegers2(int[] A) {
        int N = A.length, nobleCount = 0;
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            if (A[i] == i) {
                nobleCount++;
            }
        }
        return nobleCount;
    }

    public static void main(String[] args) {
        int[] A = {-1, -5, 3, 5, -10, 4};

        int nobleCount = countNobleIntegers(A);
        System.out.println("Number of Noble Integers: " + nobleCount);

        nobleCount = countNobleIntegers1(A);
        System.out.println("Number of Noble Integers: " + nobleCount);

        nobleCount = countNobleIntegers2(A);
        System.out.println("Number of Noble Integers: " + nobleCount);
    }
}
