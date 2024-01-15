package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q6_Sort_based_on_factors {
    /**
     * Problem: Given array A[N]. Sort then in increasing order of their number of factors.
     * If two elements have same factors, then an element with lesser value should come first
     * int[] A = {9, 3, 4, 8, 16, 37, 6, 13, 15}
     * **/
    // Function to count the number of factors for a given number
    private static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    // Custom comparator for sorting based on factors and value
    private static class FactorsComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            int factors1 = countFactors(num1);
            int factors2 = countFactors(num2);
            if (factors1 != factors2) {
                return Integer.compare(factors1, factors2);
            } else {
                // If the number of factors is the same, compare based on the actual values
                return Integer.compare(num1, num2);
            }
        }
    }
    // Bubble Sort using the custom comparator
    private static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int N = array.length;
        boolean swapped;
        for (int i = 0; i < N - 1; i++) {
            swapped = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // Swap array[j] and array[j + 1]
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    private static <T> void swap(T[] A, int start, int end) {
        T temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        Integer[] A = {9, 3, 4, 8, 16, 37, 6, 13, 15};
        System.out.println("Before sorting : " + Arrays.toString(A));
        // Sort the array using Bubble Sort and custom comparator
        bubbleSort(A, new FactorsComparator());
        System.out.println("After sorting  : " + Arrays.toString(A));
    }
}
