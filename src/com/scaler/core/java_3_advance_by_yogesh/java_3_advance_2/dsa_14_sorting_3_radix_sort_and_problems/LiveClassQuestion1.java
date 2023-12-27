package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_14_sorting_3_radix_sort_and_problems;

import java.util.Arrays;

/**
 * @created 03/02/23 5:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Find the smallest number that can be formed by rearranging the digits of given input.
     * Note :- An array is given that contains all the digits
     * Input
     * A = {3, 4, 0, 1, 1, 4, 2}
     * o/p = {0, 1, 1, 2, 3, 4, 4}
     * **/
    private static  void rearrangingDigits(int[] A) {
        int n = A.length;
        int[] freq = new int[n];
        // find frequency
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= freq[i]; j++) {
                System.out.print(i + ", ");
            }
        }
    }
    private static void rearrangingDigits1(int[] A) {
        int n = A.length;
        int[] freq = new int[n + 1];
        // find frequency
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= freq[i]; j++) {
                A[k] = i;
                k++;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {3, 4, 0, 1, 1, 4, 2};
        rearrangingDigits(A);
        System.out.println("");
        rearrangingDigits1(A);
        System.out.printf("%s%5s", "Results : ", Arrays.toString(A));
    }
}
