package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1;

/**
 * @author Deepak Kumar Rai
 * @created 11/12/23
 * @project scaler_course_code
 */
public class Q3_Given_array_with_distinct_elements_print_all_permutations {
    /**
     * Question 3
     * Given array A[N] with distinct elements, print all permutations
     * **/
    private static void allPermutations(int[] A, int N, int i) {
        if (i == N) {
            for (int element: A) {
                System.out.print(element + ", ");
            }
            System.out.println();
            return;
        }
        // At ith index, swap from i to N - 1
        for (int j = i; j < N; j++) {
            swap(A, i, j);
            allPermutations(A, N, i + 1);
            swap(A, i, j);
        }
    }
    private static void swap(int[] A, int i , int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void main(String[] args) {
        int[] A = {6, 9, 14};
        int N = A.length, i = 0;
        allPermutations(A, N, i);
    }
}
