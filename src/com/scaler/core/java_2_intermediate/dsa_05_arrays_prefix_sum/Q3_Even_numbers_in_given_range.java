package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

import java.util.Scanner;

/**
 * @created 15/09/22 11:00 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Even_numbers_in_given_range {
    /**
     * Given an array of N elements, and Q queries. For each query Left to Right [L R].
     * Find the number of even numbers in given range.
     **/
    private static void printTotalCountEvenRange(int[] a, int N, int q) {
        Scanner in = new Scanner(System.in);
        int[] prefixSum = new int[N];

        prefixSum[0] = 1 - (a[0] % 2);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + (1 - (a[i] % 2));
        }
        for (int i = 0; i < q; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int totalEven = 1;
            if (left == 0) {
                totalEven = prefixSum[right];
            } else {
                totalEven = prefixSum[right] - prefixSum[left - 1];
            }
            System.out.println("totalEven : " + totalEven);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 7, 9, 8, 6, 5, 4, 9};
        int q = 1;
        printTotalCountEvenRange(a, a.length, q);

    }
}
