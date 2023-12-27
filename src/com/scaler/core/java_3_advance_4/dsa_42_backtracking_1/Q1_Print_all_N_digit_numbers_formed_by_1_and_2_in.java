package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Print_all_N_digit_numbers_formed_by_1_and_2_in {
    /**
     * Question 1
     * Given N Print all N digit numbers formed only by one and two in increasing order of numbers.
     * **/
    private static void printAll(int[] A, int i, int N) {
        if (i == N) {
            for (int element: A) {
                System.out.print(element + ", ");
            }
            System.out.println();
            return;
        }
        // At ith index, we have two choices
        A[i] = 1;
        printAll(A, i + 1, N);
        A[i] = 2;
        printAll(A, i + 1, N);
    }
    /**
     * T.C: 2^N * N = O(2^N * N)
     * S.C: O(N)
     * **/
    public static void main(String[] args) {
        int[] A = new int[3];
        int N = 3;
        int i = 0;
        printAll(A, i, N);
    }
}
