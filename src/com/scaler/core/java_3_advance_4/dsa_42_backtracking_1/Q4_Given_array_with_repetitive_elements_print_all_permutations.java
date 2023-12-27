package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1;

/**
 * @author Deepak Kumar Rai
 * @created 11/12/23
 * @project scaler_course_code
 */
public class Q4_Given_array_with_repetitive_elements_print_all_permutations {
    public static void generatePermutations(int[] A, int start, int n) {
        if (start == n) {
            printArray(A);
            return;
        }
        for (int i = start; i < n; i++) {
            // Skip if the element has been considered already
            if (i != start && A[i] == A[start]) {
                continue;
            }
            // Swap elements to generate permutations
            swap(A, start, i);
            // Recursively generate permutations for the remaining elements
            generatePermutations(A, start + 1, n);
            // Restore the array to its original state (backtrack)
            swap(A, start, i);
        }
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {6, 6, 9, 14};
        int n = A.length;
        System.out.println("All permutations of array A[N] with repetitive elements:");
        // Sort the array to handle repetitive elements
        java.util.Arrays.sort(A);
        generatePermutations(A, 0, n);
    }
}
